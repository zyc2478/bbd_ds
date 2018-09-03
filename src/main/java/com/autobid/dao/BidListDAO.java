package com.autobid.dao;

import com.autobid.model.BidList;
import com.autobid.model.BidListExample;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * BidListDAO继承基类
 */
@Repository
public interface BidListDAO extends MyBatisBaseDao<BidList, Integer, BidListExample> {
    Date queryMaxBidDate();
}