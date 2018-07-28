package com.autobid.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.autobid.model.BidList;
import com.autobid.model.User;
import com.autobid.service.BidListService;
import com.autobid.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public BidList getBidList(@PathVariable int listingId) {
        BidList bidList = this.bidListService.getBidListById(listingId);
        return bidList;
    }
}