package com.autobid.service;

import com.autobid.job.BidListJob;
import com.autobid.model.BidList;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)     //��ʾ�̳���SpringJUnit4ClassRunner��
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})

public class PPDServiceTest {

    private static Logger logger = Logger.getLogger(PPDServiceTest.class);

/*    @Resource
    private BidListService bidListService;*/

    @Resource
    private BidListJob bidListJob = null;

    //@Test
    public void testInsertBidList() throws Exception {
        //ppdService.fetchBidList("2018-07-01","2018-07-15");

        String bidListObj = "{\"title\":\"pdu2****305��15�ν��\",\"listingId\":119825782,\"months\":12,\"rate\":20,\"amount\":12427,\"bidAmount\":188}";
        JSONObject bidListJo = JSONObject.fromObject(bidListObj);
        System.out.println("bidListJo:" + bidListJo);
        BidList bl =(BidList)JSONObject.toBean(bidListJo,BidList.class);
        System.out.println(bl);
        //System.out.println(bl.getTitle() +  "," + bl.getAmount());
/*        bl.setAmount(3000l);
        bl.setBidAmount(288);
        bl.setListingId(1451856156);
        bl.setTitle("����Title");
        bl.setMonths(12);
        bl.setRate(10.0);*/
        System.out.println(bl);

        //System.out.println(bidListService.insertBidList(bl));
    }

    @Test
    public void testFetchBidList() throws Exception {
        bidListJob.fetchBidList("2018-07-01","2018-07-15");
    }
}
