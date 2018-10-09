/*
package com.autobid.job;

//import org.apache.log4j.Logger;

import com.autobid.util.ConfUtil;
import com.autobid.util.RedisUtil;
import org.apache.log4j.Logger;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;


*/
/**
 * @Author Richard Zeng
 * @ClassName: BidDSRun
 * @Description: ��ʱ���з������������ö�ʱ����
 * @Date 2018��2��17�� ����10:04:40
 *//*


@SuppressWarnings("deprecation")
public class BidDSRun{

    private static Logger logger = Logger.getLogger(BidDSRun.class);

    public static void main(String[] args) throws Exception {

        BidDSRun ds = new BidDSRun();
        ds.run();
    }

    public void run() throws Exception {

        // ���ȹ���
        SchedulerFactory sf = new StdSchedulerFactory();

        String cronDef = ConfUtil.getProperty("cron_def");


        // �ӹ����У���ȡһ���������ʵ��
        Scheduler sched = sf.getScheduler();

        // ��ʼ������ʵ��
        JobDetail job = JobBuilder
                .newJob(BidListJob.class)
                .withIdentity("job", "group")
                .build();
        // ÿ��12��������
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("simple", "group")
                .withSchedule(CronScheduleBuilder.cronSchedule(cronDef))
                .startNow()
                .build();

        //logger.info("���ö�ʱ����");
        sched.scheduleJob(job, trigger);
        sched.start();

    }

}*/