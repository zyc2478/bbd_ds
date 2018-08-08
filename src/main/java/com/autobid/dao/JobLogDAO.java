package com.autobid.dao;

import com.autobid.model.JobLog;
import com.autobid.model.JobLogExample;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Repository;

/**
 * JobLogDAO继承基类
 */
@Repository
public interface JobLogDAO extends MyBatisBaseDao<JobLog, Integer, JobLogExample> {
}