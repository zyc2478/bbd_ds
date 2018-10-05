package com.autobid.job;

import com.autobid.util.ConfUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;

import java.io.IOException;

@Configuration
public class QuartzJobConfig {

    /**
     * ��������������ϸ����Bean
     */
    @Bean(name = "bidListJobBean")
    public MethodInvokingJobDetailFactoryBean bidListJobBean(BidListJob bidListJob) {
        MethodInvokingJobDetailFactoryBean jobDetail = new MethodInvokingJobDetailFactoryBean();
        jobDetail.setConcurrent(false); // �Ƿ񲢷�
        jobDetail.setName("general-bidListJob"); // ���������
        jobDetail.setGroup("general"); // ����ķ���
        jobDetail.setTargetObject(bidListJob); // ��ִ�еĶ���
        jobDetail.setTargetMethod("executeJob"); // ��ִ�еķ���
        return jobDetail;
    }


    /**
     * ���ʽ����������Bean
     */
    @Bean(name = "bidListJobTrigger")
    public CronTriggerFactoryBean bidListJobTrigger(@Qualifier("bidListJobBean") MethodInvokingJobDetailFactoryBean bidListJobBean) throws IOException {
        CronTriggerFactoryBean tigger = new CronTriggerFactoryBean();
        tigger.setJobDetail(bidListJobBean.getObject());
        String cronStr = ConfUtil.getProperty("cron_def");
        tigger.setCronExpression(cronStr); // ʲô�Ƿ񴥷���Spring Scheduler Cron���ʽ
        tigger.setName("general-myFirstExerciseJobTrigger");
        return tigger;
    }

 /*   *//**
     * ��������������ϸ����Bean
     *//*
    @Bean(name = "myFirstExerciseJobBean")
    public MethodInvokingJobDetailFactoryBean myFirstExerciseJobBean(MyFirstExerciseJob myFirstExerciseJob) {
        MethodInvokingJobDetailFactoryBean jobDetail = new MethodInvokingJobDetailFactoryBean();
        jobDetail.setConcurrent(false); // �Ƿ񲢷�
        jobDetail.setName("general-myFirstExerciseJob"); // ���������
        jobDetail.setGroup("general"); // ����ķ���
        jobDetail.setTargetObject(myFirstExerciseJob); // ��ִ�еĶ���
        jobDetail.setTargetMethod("myJobBusinessMethod"); // ��ִ�еķ���
        return jobDetail;
    }

    *//**
     * ���ʽ����������Bean
     *//*
    @Bean(name = "myFirstExerciseJobTrigger")
    public CronTriggerFactoryBean myFirstExerciseJobTrigger(@Qualifier("myFirstExerciseJobBean") MethodInvokingJobDetailFactoryBean myFirstExerciseJobBean) {
        CronTriggerFactoryBean tigger = new CronTriggerFactoryBean();
        tigger.setJobDetail(myFirstExerciseJobBean.getObject());
        tigger.setCronExpression("0/10 * * * * ?"); // ʲô�Ƿ񴥷���Spring Scheduler Cron���ʽ
        tigger.setName("general-myFirstExerciseJobTrigger");
        return tigger;
    }

    *//**
     * ��������������ϸ����Bean
     *//*
    @Bean(name = "mySecondExerciseJobBean")
    public MethodInvokingJobDetailFactoryBean mySecondExerciseJobBean(MySecondExerciseJob mySecondExerciseJob) {
        MethodInvokingJobDetailFactoryBean jobDetail = new MethodInvokingJobDetailFactoryBean();
        jobDetail.setConcurrent(false); // �Ƿ񲢷�
        jobDetail.setName("general-mySecondExerciseJob"); // ���������
        jobDetail.setGroup("general"); // ����ķ���
        jobDetail.setTargetObject(mySecondExerciseJob); // ��ִ�еĶ���
        jobDetail.setTargetMethod("myJobBusinessMethod"); // ��ִ�еķ���
        return jobDetail;
    }

    *//**
     * ���ʽ����������Bean
     *//*
    @Bean(name = "mySecondExerciseJobTrigger")
    public CronTriggerFactoryBean mySecondExerciseJobTrigger(@Qualifier("mySecondExerciseJobBean") MethodInvokingJobDetailFactoryBean mySecondExerciseJobDetailFactoryBean) {
        CronTriggerFactoryBean tigger = new CronTriggerFactoryBean();
        tigger.setJobDetail(mySecondExerciseJobDetailFactoryBean.getObject());
        tigger.setCronExpression("0/10 * * * * ?"); // ʲô�Ƿ񴥷���Spring Scheduler Cron���ʽ
        tigger.setName("general-mySecondExerciseJobTrigger");
        return tigger;
    }*/

}