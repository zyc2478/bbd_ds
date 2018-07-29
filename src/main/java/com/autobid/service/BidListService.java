package com.autobid.service;

import com.autobid.model.BidList;

import java.util.List;

public interface BidListService {

    int insertBidList(BidList bidList);

    List<BidList> getBidListByListingId(int listingId);
}
