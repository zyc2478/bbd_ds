package com.autobid.job;

//import org.apache.log4j.Logger;

import com.autobid.util.ConfUtil;
import com.autobid.util.RedisUtil;
import org.apache.log4j.Logger;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;


/**
 * @Author Richard Zeng
 * @ClassName: BidDSRun
 * @Description: 定时运行服务，在这里配置定时任务
 * @Date 2018年2月17日 下午10:04:40
 */

@SuppressWarnings("deprecation")
public class BidDSRun{

    private static Logger logger = Logger.getLogger(BidDSRun.class);

    public static void main(String[] args) throws Exception {

        BidDSRun ds = new BidDSRun();
        ds.run();
    }

    public void run() throws Exception {

        // 调度工厂
        SchedulerFactory sf = new StdSchedulerFactory();

        int runInterval = Integer.parseInt(ConfUtil.getProperty("run_interval"));

        // 从工厂中，获取一个任务调度实体
        Scheduler sched = sf.getScheduler();

        // 初始化任务实体
        JobDetail job = JobBuilder
                .newJob(BidListJob.class)
                .withIdentity("job", "group")
                .build();
        // 每天12点整运行
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("simple", "group")
                .withSchedule(CronScheduleBuilder.cronSchedule("10 18 18 * * ?"))
                .startNow()
                .build();

        //logger.info("设置定时任务");
        sched.scheduleJob(job, trigger);
        sched.start();

    }

}