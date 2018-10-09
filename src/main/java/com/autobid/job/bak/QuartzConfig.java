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
     * 调度器工厂Bean
     *//*
    @Bean(name = "schedulerFactory")
    public SchedulerFactoryBean schedulerFactory(@Qualifier("bidListJobTrigger") Trigger bidListJobTrigger) {
        SchedulerFactoryBean bean = new SchedulerFactoryBean();
        // 覆盖已存在的任务
        bean.setOverwriteExistingJobs(true);
        // 延时启动定时任务，避免系统未完全启动却开始执行定时任务的情况
        bean.setStartupDelay(5);
        // 注册触发器
        bean.setTriggers(bidListJobTrigger);
        return bean;
    }*/
/*    @Bean(name = "schedulerFactory")
    public SchedulerFactoryBean schedulerFactory(@Qualifier("myFirstExerciseJobTrigger") Trigger myFirstExerciseJobTrigger,
                                                 @Qualifier("mySecondExerciseJobTrigger") Trigger mySecondExerciseJobTrigger) {
        SchedulerFactoryBean bean = new SchedulerFactoryBean();
        // 覆盖已存在的任务
        bean.setOverwriteExistingJobs(true);
        // 延时启动定时任务，避免系统未完全启动却开始执行定时任务的情况
        bean.setStartupDelay(15);
        // 注册触发器
        bean.setTriggers(myFirstExerciseJobTrigger, mySecondExerciseJobTrigger);
        return bean;
    }*/

    private JobFactory jobFactory;

    public QuartzConfig(JobFactory jobFactory){
        this.jobFactory = jobFactory;
    }

    /**
     * 配置SchedulerFactoryBean
     *
     * 将一个方法产生为Bean并交给Spring容器管理
     */
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() {
        // Spring提供SchedulerFactoryBean为Scheduler提供配置信息,并被Spring容器管理其生命周期
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        // 设置自定义Job Factory，用于Spring管理Job bean
        factory.setJobFactory(jobFactory);
        return factory;
    }

    @Bean(name = "scheduler")
    public Scheduler scheduler() {
        return schedulerFactoryBean().getScheduler();
    }
}
