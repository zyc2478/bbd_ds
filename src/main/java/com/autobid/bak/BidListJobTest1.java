package com.autobid.bak;

import com.autobid.service.BidListService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration("src/main/webapp")
@ContextConfiguration(locations = { "classpath:application.yml" })
public class BidListJobTest1 {

    @Resource
    private BidListService bidListService ;

    @Test
    public void testBidList(){
        System.out.println("Test bidListService:" + bidListService.getBidListByListingId(62068730));

    }
}
