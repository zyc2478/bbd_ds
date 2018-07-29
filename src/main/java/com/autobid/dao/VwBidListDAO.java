package com.autobid.dao;

import com.autobid.model.VwBidList;
import com.autobid.model.VwBidListExample;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Repository;

/**
 * VwBidListDAO继承基类
 */
@Repository
public interface VwBidListDAO extends MyBatisBaseDao<VwBidList, VwBidList, VwBidListExample> {
}