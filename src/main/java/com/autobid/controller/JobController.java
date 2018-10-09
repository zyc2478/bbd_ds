package com.autobid.controller;

import java.util.List;

import com.autobid.aop.Log;
import com.autobid.model.JobAndTrigger;
import com.autobid.model.Result;
import com.autobid.service.IJobAndTriggerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author Bob Simon
 * @Description��������Ʋ�
 * @Date :Created in 2018-04-25 15:10
 * @Modified By
 **/
@Api(tags ="Quartz����")
@RestController
@RequestMapping(value="/job")
public class JobController{

    private static Logger log = LoggerFactory.getLogger(JobController.class);

    /**����Qulifierע�⣬ͨ������ע��bean*/
    @Autowired @Qualifier("Scheduler")
    private Scheduler scheduler;

    @Autowired
    private IJobAndTriggerService iJobAndTriggerService;

    /**
     * �½�����
     * @param quartz
     * @return
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @ApiOperation(value="�½�����")
    @PostMapping("/add")
    //@Log(desc = "������ʱ����",type = Log.LOG_TYPE.ADD)
    public Result save(JobAndTrigger quartz){
        log.info("��������");
        try {
            /**
             * ��ȡSchedulerʵ����������ʹ���Զ�ע���scheduler������spring��service���޷�ע��
             * Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
             * ������޸� ,չʾ�ɵ�����
             */
            if(quartz.getOldJobGroup()!=null){
                JobKey key = new JobKey(quartz.getOldJobName(),quartz.getOldJobGroup());
                scheduler.deleteJob(key);
            }

            Class cls = Class.forName(quartz.getJobClassName()) ;
            cls.newInstance();

            /***����job��Ϣ*/
            JobDetail job = JobBuilder.newJob(cls).withIdentity(quartz.getJobName(),
                    quartz.getJobGroup())
                    .withDescription(quartz.getDescription()).build();

            /***����ʱ���*/
            CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(quartz.getCronExpression());
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger"+quartz.getJobName(),quartz.getJobGroup())
                    .startNow().withSchedule(cronScheduleBuilder).build();

            /***����Scheduler���Ŵ���*/
            scheduler.scheduleJob(job,trigger);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error();
        }
        return Result.ok();
    }

    /**
     * ��ȡ�����б�
     * @param jobName
     * @param pageNo
     * @param pageSize
     * @return
     */
    @ApiOperation(value="�����б�")
    @PostMapping("/list")
    @Log(desc = "��ѯ��ʱ����",type = Log.LOG_TYPE.SELECT)
    public Result list(@RequestParam(value = "jobName",required = false)String jobName,
                       @RequestParam("pageNo")Integer pageNo,
                       @RequestParam("pageSize")Integer pageSize){
        log.info("�����б�");

        List<JobAndTrigger> list = iJobAndTriggerService.listQuartzEntity(jobName,pageNo,pageSize);
        return Result.ok(list);
    }

    /**
     * ��������
     * @param quartz
     * @param response
     * @return
     */
    @ApiOperation(value="��������")
    @PostMapping("/trigger")
    //@Log(desc = "������ʱ����")
    public  Result trigger(JobAndTrigger quartz,HttpServletResponse response) {
        log.info("��������");
        try {
            JobKey key = new JobKey(quartz.getJobName(),quartz.getJobGroup());
            scheduler.triggerJob(key);
        } catch (SchedulerException e) {
            e.printStackTrace();
            return Result.error();
        }
        return Result.ok();
    }

    /**
     * ֹͣ����
     * @param quartz
     * @param response
     * @return
     */
    @ApiOperation(value="ֹͣ����")
    @PostMapping("/pause")
    //@Log(desc = "ֹͣ����")
    public  Result pause(JobAndTrigger quartz,HttpServletResponse response) {
        log.info("ֹͣ����");
        try {
            JobKey key = new JobKey(quartz.getJobName(),quartz.getJobGroup());
            scheduler.pauseJob(key);
        } catch (SchedulerException e) {
            e.printStackTrace();
            return Result.error();
        }
        return Result.ok();
    }

    /**
     * �ָ�����
     * @param quartz
     * @param response
     * @return
     */
    @ApiOperation(value="�ָ�����")
    @PostMapping("/resume")
    //@Log(desc = "�ָ�����")
    public  Result resume(JobAndTrigger quartz,HttpServletResponse response) {
        log.info("�ָ�����");
        try {
            JobKey key = new JobKey(quartz.getJobName(),quartz.getJobGroup());
            scheduler.resumeJob(key);
        } catch (SchedulerException e) {
            e.printStackTrace();
            return Result.error();
        }
        return Result.ok();
    }

    /**
     * �Ƴ�����
     * @param quartz
     * @param response
     * @return
     */
    @ApiOperation(value="�Ƴ�����")
    @PostMapping("/remove")
    // @Log(desc = "�Ƴ�����")
    public Result remove(JobAndTrigger quartz,HttpServletResponse response) {
        try {
            TriggerKey triggerKey = TriggerKey.triggerKey(quartz.getJobName(), quartz.getJobGroup());

            /***ֹͣ������*/
            scheduler.pauseTrigger(triggerKey);

            /**�Ƴ�������*/
            scheduler.unscheduleJob(triggerKey);

            /***ɾ������*/
            scheduler.deleteJob(JobKey.jobKey(quartz.getJobName(), quartz.getJobGroup()));
            System.out.println("removeJob:" + JobKey.jobKey(quartz.getJobName()));
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error();
        }
        return Result.ok();
    }

}
