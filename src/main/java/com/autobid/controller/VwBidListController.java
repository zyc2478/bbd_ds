package com.autobid.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.autobid.model.BidList;
import com.autobid.model.User;
import com.autobid.model.VwBidList;
import com.autobid.service.BidListService;
import com.autobid.service.IUserService;
import com.autobid.service.VwBidListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/vwBidList")
public class VwBidListController {

    @Resource
    private VwBidListService vwBidListService;

    @CrossOrigin(origins="*",maxAge=3600)
    @RequestMapping(value="/getVwBidList/{diffDays}", produces = "text/json; charset=utf-8")
    @ResponseBody
    public List<VwBidList> getBidList(@PathVariable int diffDays) {

        List<VwBidList>  vwBidSummary = this.vwBidListService.getBidSummary(diffDays);

        return vwBidSummary;
    }
/*    @RequestMapping(value="/getVwBidList/{diffDays}", produces = "text/json; charset=utf-8")
    @ResponseBody
    public List<VwBidList> getBidList(@PathVariable int diffDays) {

        List<VwBidList>  vwBidSummary = this.vwBidListService.getBidSummary(diffDays);

        return vwBidSummary;
    }*/
}