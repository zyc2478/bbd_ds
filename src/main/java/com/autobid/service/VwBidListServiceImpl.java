package com.autobid.service;

import com.autobid.dao.VwBidListDAO;
import com.autobid.model.VwBidList;
import com.autobid.model.VwBidListExample;
import com.autobid.util.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service("vwBidListService")
public class VwBidListServiceImpl implements VwBidListService {

    @Resource
    private VwBidListDAO vwBidListDAO;

    @Override
    public List<VwBidList> getBidSummary(int diffDays) {

        VwBidListExample vwBidListExample = new VwBidListExample();
        Date beginDate = DateUtil.calcBeginDate(new Date(),diffDays);
        long beginDataTime = beginDate.getTime();
        vwBidListExample.createCriteria().andBid_date_timeGreaterThan(beginDate);
        return this.vwBidListDAO.selectByExample(vwBidListExample);
    }
}