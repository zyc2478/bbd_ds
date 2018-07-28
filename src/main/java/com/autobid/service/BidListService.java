package com.autobid.service;

import com.autobid.model.BidList;
import com.autobid.model.User;

public interface BidListService {

    int insertBidList(BidList bidList);

    BidList getBidListById(int listingId);
}
