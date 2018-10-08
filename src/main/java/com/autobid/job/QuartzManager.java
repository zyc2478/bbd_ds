package com.autobid.job;

import org.quartz.*;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class QuartzManager {
    private Scheduler scheduler;

    public QuartzManager(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    /**
     * ���һ����ʱ����
     *
     * @param jobName          ������
     * @param jobGroupName     ��������
     * @param triggerName      ��������
     * @param triggerGroupName ����������
     * @param jobClass         ����
     * @param cron             ʱ�����ã��ο�quartz˵���ĵ�
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public void addJob(String jobName, String jobGroupName, String triggerName, String triggerGroupName, Class jobClass, String cron, Map<String, Object> params) {
        try {
            // �������������飬����ִ����
            JobDetail job = JobBuilder.newJob(jobClass).withIdentity(jobName, jobGroupName).build();
            // �������
            job.getJobDataMap().putAll(params);

            // ������
            TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
            // ��������,��������
            triggerBuilder.withIdentity(triggerName, triggerGroupName);
            triggerBuilder.startNow();
            // ������ʱ���趨
            triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cron));
            // ����Trigger����
            CronTrigger trigger = (CronTrigger) triggerBuilder.build();

            // ������������JobDetail��Trigger
            scheduler.scheduleJob(job, trigger);

            // ����
            if (!scheduler.isShutdown()) {
                scheduler.start();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * �޸�һ������Ĵ���ʱ��
     *
     * @param triggerName      ��������
     * @param triggerGroupName ����������
     * @param cron             ʱ�����ã��ο�quartz˵���ĵ�
     */
    public void modifyJobTime(String triggerName, String triggerGroupName, String cron) {
        try {
            TriggerKey triggerKey = TriggerKey.triggerKey(triggerName, triggerGroupName);
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            if (trigger == null) {
                return;
            }

            String oldTime = trigger.getCronExpression();
            if (!oldTime.equalsIgnoreCase(cron)) {
                // ������
                TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
                // ��������,��������
                triggerBuilder.withIdentity(triggerName, triggerGroupName);
                triggerBuilder.startNow();
                // ������ʱ���趨
                triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cron));
                // ����Trigger����
                trigger = (CronTrigger) triggerBuilder.build();
                // ��ʽһ ���޸�һ������Ĵ���ʱ��
                scheduler.rescheduleJob(triggerKey, trigger);

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * �Ƴ�һ������
     *
     * @param jobName          ������
     * @param jobGroupName     ��������
     * @param triggerName      ��������
     * @param triggerGroupName ����������
     */
    public void removeJob(String jobName, String jobGroupName, String triggerName, String triggerGroupName) {
        try {

            TriggerKey triggerKey = TriggerKey.triggerKey(triggerName, triggerGroupName);

            // ֹͣ������
            scheduler.pauseTrigger(triggerKey);
            // �Ƴ�������
            scheduler.unscheduleJob(triggerKey);
            // ɾ������
            scheduler.deleteJob(JobKey.jobKey(jobName, jobGroupName));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * ��ȡ�����Ƿ����
     * <p>
     * STATE_BLOCKED 4 ����
     * STATE_COMPLETE 2 ���
     * STATE_ERROR 3 ����
     * STATE_NONE -1 ������
     * STATE_NORMAL 0 ����
     * STATE_PAUSED 1 ��ͣ
     */
    public Boolean notExists(String triggerName, String triggerGroupName) {
        try {
            return scheduler.getTriggerState(TriggerKey.triggerKey(triggerName, triggerGroupName)) == Trigger.TriggerState.NONE;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
