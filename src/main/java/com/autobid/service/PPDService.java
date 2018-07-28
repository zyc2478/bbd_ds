package com.autobid.service;

import com.autobid.model.BidList;
import com.autobid.util.InitUtil;
import com.autobid.util.JSONUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})

public class PPDService {

    private static Logger logger = Logger.getLogger("PPDService.class");

    private static String token = "";

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


    public void fetchBidList(String startDate,String endDate) throws Exception {
        init();
        System.out.println(token);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        JSONArray bidListArray = PPDApiService.bidList(token,startDate, endDate,1,50);
        for(Object bidListObj:bidListArray){

            JSONObject bidListJO = JSONObject.fromObject(bidListObj);
            //System.out.println("bidListJO: " + bidListJO);
            JSONObject transBidListJO = JSONUtil.transFirstLowerObj(bidListJO);
            //System.out.println("transBidListJO: " + transBidListJO);
            Date bidDate = sdf.parse(endDate);
            BidList bl =(BidList)JSONObject.toBean(transBidListJO,BidList.class);
            bl.setBidDate(bidDate);
            System.out.println("bl: " + bl);
            //System.out.println(bl.getTitle() +  "," + bl.getAmount());
            System.out.println(bidListService.insertBidList(bl));
        }
    }
    @Test
    public void testFetchBidList() throws Exception {
        this.fetchBidList("2018-04-12","2018-04-12");
    }
}
