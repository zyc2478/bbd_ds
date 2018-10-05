package com.autobid.dao;

import com.autobid.model.VwBidList;
import com.autobid.model.VwBidListExample;
import org.springframework.stereotype.Repository;

/**
 * VwBidListDAO继承基类
 */
@Repository
public interface VwBidListDAO extends MyBatisBaseDao<VwBidList, VwBidList, VwBidListExample> {
}