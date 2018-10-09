package com.autobid.job;

import com.autobid.service.IJobAndTriggerService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * @Author: Bob Simon
 * @Description: ʵ�����л��ӿڡ���ֹ����Ӧ�ó���quartz Couldn't retrieve job because a required class was not found ������
 * @Date: Created in 9:32 2018\4\29
 */
public class TestJob implements Job,Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private IJobAndTriggerService jobService;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        /**ע��jobService ִ�����ҵ�����*/
        System.out.println("jobService.listQuartzEntityNum(null) : " + jobService.listQuartzEntityNum(null));
        //System.out.println(jobService);
        System.out.println("����ִ�гɹ�");
    }

}