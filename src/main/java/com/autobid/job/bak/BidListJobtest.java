package com.autobid.job.bak;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class BidListJobtest implements Job,Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        /**ע��jobService ִ�����ҵ�����*/
        //System.out.println(jobService);
        System.out.println("����ִ�гɹ�");
    }
}
