package com.autobid.service;

import com.autobid.model.VwBidList;

import java.util.List;

public interface VwBidListService {

    List<VwBidList> getBidSummary(int lastDaysNum);
}
