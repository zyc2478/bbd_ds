package com.autobid.service;

import com.autobid.model.BidList;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public interface BidListService {

    int insertBidList(BidList bidList);

    List<BidList> getBidListByListingId(int listingId);

    List<BidList> queryBidDate(Date inputDate);

    Date queryMaxBidDate();
}
