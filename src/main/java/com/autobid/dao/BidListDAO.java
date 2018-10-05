package com.autobid.dao;

import com.autobid.model.BidList;
import com.autobid.model.BidListExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;

/**
 * BidListDAO继承基类
 */
//@Repository
@Mapper
public interface BidListDAO extends MyBatisBaseDao<BidList, Integer, BidListExample> {
    Date queryMaxBidDate();
}