package com.autobid.controller;

import javax.annotation.Resource;

import com.autobid.model.BidList;
import com.autobid.service.BidListService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/bidList")
public class BidListController {

    @Resource
    private BidListService bidListService;

    /**
     * 使用JSON作为响应内容
     */

    // @CrossOrigin(origins="*",maxAge=3600)
    //@RequestMapping(value="/getUser/{userID}",method= RequestMethod.GET)
    @CrossOrigin(origins="*",maxAge=3600)
    @RequestMapping(value="/getBidList/{listingId}", produces = "text/json; charset=utf-8")
    @ResponseBody
    public List<BidList> getBidList(@PathVariable int listingId) {
        List<BidList> bidLists = this.bidListService.getBidListByListingId(listingId);
        return bidLists;
    }
}