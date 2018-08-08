package com.autobid.service;

import com.autobid.dao.BidListDAO;
import com.autobid.model.BidList;
import com.autobid.model.BidListExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("bidListService")
public class BidListServiceImpl implements BidListService {

    @Resource
    private BidListDAO bidListDao;

    @Override
    public int insertBidList(BidList bidList) { return this.bidListDao.insert(bidList); }

    BidListExample bidListExample = new BidListExample();

    @Override
    public List<BidList> getBidListByListingId(int listingId) {

        bidListExample.createCriteria().andListingIdEqualTo(new Integer(listingId));
        return this.bidListDao.selectByExample(bidListExample);
    }

}