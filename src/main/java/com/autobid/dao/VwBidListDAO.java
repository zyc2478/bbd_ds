package com.autobid.dao;

import com.autobid.model.VwBidList;
import com.autobid.model.VwBidListExample;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * VwBidListDAO继承基类
 */
@Repository
@Mapper
public interface VwBidListDAO extends MyBatisBaseDao<VwBidList, VwBidList, VwBidListExample> {
}