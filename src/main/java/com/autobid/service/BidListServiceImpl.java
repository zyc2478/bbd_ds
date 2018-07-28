package com.autobid.service;

import com.autobid.dao.BidListDAO;
import com.autobid.dao.BidListMapper;
import com.autobid.model.BidList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("bidListService")
public class BidListServiceImpl implements BidListService {

    @Resource
    private BidListDAO bidListDao;

    @Override
    public int insertBidList(BidList bidList) { return this.bidListDao.insert(bidList); }

    @Override
    public BidList getBidListById(int listingId) { return this.bidListDao.selectByPrimaryKey(new Integer(listingId)); }

}