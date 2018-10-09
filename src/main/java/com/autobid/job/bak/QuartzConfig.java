package com.autobid.job.bak;

import org.quartz.Scheduler;
import org.quartz.spi.JobFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.io.IOException;
import java.util.Properties;

@Configuration
public class QuartzConfig {

 /*   @Bean
    public JobFactory jobFactory(ApplicationContext applicationContext) {
        AutowiringSpringBeanJobFactory jobFactory = new AutowiringSpringBeanJobFactory();
        jobFactory.setApplicationContext(applicationContext);
        return jobFactory;
    }

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(JobFactory jobFactory) throws Exception {
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        factory.setOverwriteExistingJobs(true);
        factory.setJobFactory(jobFactory);
        factory.setQuartzProperties(quartzProperties());
        factory.afterPropertiesSet();
        return factory;
    }

    @Bean
    public Properties quartzProperties() throws IOException {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new ClassPathResource("/quartz.properties"));
        propertiesFactoryBean.afterPropertiesSet();
        return propertiesFactoryBean.getObject();
    }
*/
 /*   *//**
     * ����������Bean
     *//*
    @Bean(name = "schedulerFactory")
    public SchedulerFactoryBean schedulerFactory(@Qualifier("bidListJobTrigger") Trigger bidListJobTrigger) {
        SchedulerFactoryBean bean = new SchedulerFactoryBean();
        // �����Ѵ��ڵ�����
        bean.setOverwriteExistingJobs(true);
        // ��ʱ������ʱ���񣬱���ϵͳδ��ȫ����ȴ��ʼִ�ж�ʱ��������
        bean.setStartupDelay(5);
        // ע�ᴥ����
        bean.setTriggers(bidListJobTrigger);
        return bean;
    }*/
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

    private JobFactory jobFactory;

    public QuartzConfig(JobFactory jobFactory){
        this.jobFactory = jobFactory;
    }

    /**
     * ����SchedulerFactoryBean
     *
     * ��һ����������ΪBean������Spring��������
     */
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() {
        // Spring�ṩSchedulerFactoryBeanΪScheduler�ṩ������Ϣ,����Spring������������������
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        // �����Զ���Job Factory������Spring����Job bean
        factory.setJobFactory(jobFactory);
        return factory;
    }

    @Bean(name = "scheduler")
    public Scheduler scheduler() {
        return schedulerFactoryBean().getScheduler();
    }
}
