package com.autobid.job;

import com.autobid.model.BidList;
import com.autobid.service.BidListService;
import com.autobid.api.PPDApiService;
import com.autobid.util.DateUtil;
import com.autobid.util.InitUtil;
import com.autobid.util.JSONUtil;
import com.autobid.util.RedisUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})

public class BidListJob implements Job {

    private static Logger logger = Logger.getLogger("PPDService.class");

    private static String token = "";

    Jedis jedis = RedisUtil.getJedis();


    @Resource
    private BidListService bidListService = null;

    public void init() {
        try {
            InitUtil.init();
            token = InitUtil.getToken();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String today = sdf.format(new Date());
        try {
            //this.fetchBidList(today,today);
            this.fetchEveryDay();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void fetchBidList(String startDate,String endDate) throws Exception {
        init();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        int pageIndex = 1, pageSize = 50;
        int bidCount;
        do{
            //System.out.println("in while");
            bidCount = 0;
            JSONArray bidListArray = PPDApiService.bidList(token,startDate, endDate,pageIndex,pageSize);

            for(Object bidListObj:bidListArray){

                JSONObject bidListJO = JSONObject.fromObject(bidListObj);
                //System.out.println("bidListJO: " + bidListJO);
                JSONObject transBidListJO = JSONUtil.transFirstLowerObj(bidListJO);
                //System.out.println("transBidListJO: " + transBidListJO);
                BidList bl = new BidList();
                if(transBidListJO.getInt("listingId")!=0 && transBidListJO.get("title")!=null){
                    Date bidDate = sdf.parse(endDate);
                    bl =(BidList)JSONObject.toBean(transBidListJO,BidList.class);
                    bl.setBidDate(bidDate);
                    System.out.println("bl: " + bl);
                    System.out.println("insert " + bidListService.insertBidList(bl) + " record(s) in bid_list");
                }
                bidCount++;
                System.out.println("bidCount:" + bidCount);
            }
            pageIndex++;
            System.out.println("pageIndex: " + pageIndex);

        }while(bidCount == 50);
        jedis.set("job_bid_list",endDate);
        System.out.println("jedis job_bid_list value: " + endDate);
    }

    @Test
    public void fetchEveryDay() throws Exception {
        String startDate = jedis.get("job_bid_list");
        System.out.println("get startDate: " + startDate);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date today = new Date();
        Date yesterday = new Date(today.getTime() - 1000 * 24 * 3600);
        String endDate = sdf.format(yesterday);
        if(startDate.equals(endDate)){
            logger.warning("该日期已经执行过bid_list任务");
        }else{
            fetchBidList(endDate,endDate);
        }
    }
    //@Test
    public void testFetchBidList() throws Exception {
/*        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date today = new Date();
        Date yesterday = new Date(today.getTime() - 1000 * 24 * 3600);
        String endDate = sdf.format(yesterday);
        System.out.println(endDate);*/
        this.fetchBidList("2018-08-06","2018-08-06");
    }

    //@Test
    public void initAll() throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String beginDateStr = "2017-07-27";
        Date beginDate = sdf.parse(beginDateStr);

        int diffDays = DateUtil.differentDaysByMillisecond(beginDate,new Date());
        System.out.println("diffDays: " + diffDays);

        for(int i = 0; i < diffDays; i++){
            this.fetchBidList(sdf.format(beginDate),sdf.format(beginDate));
            beginDate = DateUtil.calcBeginDate(beginDate,-1);
            System.out.println(i);
        }
    }


}
