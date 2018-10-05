package com.autobid.job;

import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
public class QuartzConfig {

    /**
     * ����������Bean
     */
    @Bean(name = "schedulerFactory")
    public SchedulerFactoryBean schedulerFactory(@Qualifier("bidListJobTrigger") Trigger bidListJobTrigger) {
        SchedulerFactoryBean bean = new SchedulerFactoryBean();
        // �����Ѵ��ڵ�����
        bean.setOverwriteExistingJobs(true);
        // ��ʱ������ʱ���񣬱���ϵͳδ��ȫ����ȴ��ʼִ�ж�ʱ��������
        bean.setStartupDelay(15);
        // ע�ᴥ����
        bean.setTriggers(bidListJobTrigger);
        return bean;
    }
/*    @Bean(name = "schedulerFactory")
    public SchedulerFactoryBean schedulerFactory(@Qualifier("myFirstExerciseJobTrigger") Trigger myFirstExerciseJobTrigger,
                                                 @Qualifier("mySecondExerciseJobTrigger") Trigger mySecondExerciseJobTrigger) {
        SchedulerFactoryBean bean = new SchedulerFactoryBean();
        // �����Ѵ��ڵ�����
        bean.setOverwriteExistingJobs(true);
        // ��ʱ������ʱ���񣬱���ϵͳδ��ȫ����ȴ��ʼִ�ж�ʱ��������
        bean.setStartupDelay(15);
        // ע�ᴥ����
        bean.setTriggers(myFirstExerciseJobTrigger, mySecondExerciseJobTrigger);
        return bean;
    }*/

}