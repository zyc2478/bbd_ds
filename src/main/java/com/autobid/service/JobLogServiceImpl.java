package com.autobid.service;

import com.autobid.dao.BidListDAO;
import com.autobid.dao.JobLogDAO;
import com.autobid.model.JobLog;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("jobLogService")
public class JobLogServiceImpl implements JobLogService {


    @Resource
    private JobLogDAO jobLogDAO;

    @Override
    public int insertJobLog(JobLog jobLog) {
        return this.jobLogDAO.insert(jobLog);
    }
}
