package com.autobid.job;

import com.autobid.model.BidList;
import com.autobid.model.JobLog;
import com.autobid.service.BidListService;
import com.autobid.api.PPDApiService;
import com.autobid.service.JobLogService;
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

    @Resource
    private JobLogService jobLogService = null;

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
        SimpleDateFormat sdf_detail = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date start_time = null;
        Date end_time = null;
        Date bidDate = sdf.parse(endDate);

        int pageIndex = 1, pageSize = 50;
        int bidCount;
        start_time = new Date();

        do{
            //System.out.println("in while");
            bidCount = 0;
            JSONArray bidListArray = PPDApiService.bidList(token,startDate, endDate,pageIndex,pageSize);
            for(Object bidListObj:bidListArray){

                JSONObject bidListJO = JSONObject.fromObject(bidListObj);
                //System.out.println("bidListJO: " + bidListJO);
                JSONObject transBidListJO = JSONUtil.transFirstLowerObj(bidListJO);
                //System.out.println("transBidListJO: " + transBidListJO);

                if(transBidListJO.getInt("listingId")!=0 && transBidListJO.get("title")!=null){

                    BidList bl =(BidList)JSONObject.toBean(transBidListJO,BidList.class);
                    bl.setBidDate(bidDate);
                    // System.out.println("bl: " + bl);

                    System.out.println("insert " + bidListService.insertBidList(bl) + " record(s) in bid_list");

                }else{
                    logger.warning( bidDate + " 没有投标！");
                }
                bidCount++;
                System.out.println("bidCount:" + bidCount);
            }
            pageIndex++;
            System.out.println("pageIndex: " + pageIndex);

        }while(bidCount == 50);

        end_time = new Date();
        System.out.println("end_time: "+ end_time);
        jedis.set("job_bid_list",endDate);

        JobLog jobLog = new JobLog();
        jobLog.setJob_name("bid_list" + "_" + endDate);
        jobLog.setJob_type("bid_list");
        jobLog.setRun_result("Successful");
        jobLog.setStart_time(start_time);
        jobLog.setEnd_time(end_time);

        System.out.println("insert " + jobLogService.insertJobLog(jobLog) + " record(s) in job_log");
    }

    @Test
    public void fetchEveryDay() throws Exception {
        String saveDate = jedis.get("job_bid_list");
        System.out.println("get startDate: " + saveDate);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date today = new Date();
        Date yesterday = new Date(today.getTime() - 1000 * 24 * 3600);
        String endDate = sdf.format(yesterday);
        System.out.println("endDate:" + endDate);
        if(saveDate.equals(endDate)){
            logger.warning("该日期已经执行过bid_list任务");
        }else{
            fetchBidList(endDate,endDate);
        }
    }

    //@Test
    public void testJobLogInsert() throws Exception {
        JobLog jobLog = new JobLog();
        jobLog.setJob_name("bid_list" + "_" + "2018-08-07");
        jobLog.setJob_type("bid_list");
        Date testDate = new Date();
        jobLog.setRun_result("Successful");
        jobLog.setStart_time(testDate);
        jobLog.setEnd_time(testDate);

        System.out.println("insert " + jobLogService.insertJobLog(jobLog) + " record(s) in job_log");

    }
    //@Test
    public void testFetchBidList() throws Exception {
/*        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date today = new Date();
        Date yesterday = new Date(today.getTime() - 1000 * 24 * 3600);
        String endDate = sdf.format(yesterday);
        System.out.println(endDate);*/
        this.fetchBidList("2018-08-08","2018-08-08");
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
