package com.autobid.dao;

import com.autobid.model.JobLog;
import com.autobid.model.JobLogExample;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * JobLogDAO继承基类
 */
@Mapper
public interface JobLogDAO extends MyBatisBaseDao<JobLog, Integer, JobLogExample> {
}