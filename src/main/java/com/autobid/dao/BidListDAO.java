package com.autobid.dao;

import com.autobid.model.BidList;
import com.autobid.model.BidListExample;
import org.springframework.stereotype.Repository;

/**
 * BidListDAO继承基类
 */
@Repository
public interface BidListDAO extends MyBatisBaseDao<BidList, Integer, BidListExample> {
}