package com.autobid.job;

import com.autobid.model.BidList;
import org.assertj.core.util.Maps;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BidListTask {
    // 任务名前缀
    private final String job_prefix = "job_";
    // 任务组前缀
    private final String job_group_prefix = "job_group_";
    // 触发器前缀
    private final String trigger_prefix = "trigger_";
    // 触发组前缀
    private final String trigger_group_prefix = "trigger_group_";

    @Value("${job.cron}")
    private String cronStr;

    private QuartzManager quartzManager;

    public BidListTask(QuartzManager quartzManager) {
        this.quartzManager = quartzManager;
    }

/*    *//**
     *  根据配置生成cron表达式
     *//*
    private String getCron(SftpDTO dto) {

        // 时
        Integer hour = dto.getHour();
        // 分
        Integer minute = dto.getMinute();
        // 每周几
        Integer week = dto.getWeek();
        // 每月几号
        Integer day = dto.getDay();

        *//* 执行时间 0每天,1每周,2每月 *//*
        Integer execType = dto.getExecType();

        String cron;
        switch (execType) {
            case 0:
                cron = String.format("0 %s %s * * ?", minute, hour);
                break;
            case 1:
                cron = String.format("0 %s %s ? * %s", minute, hour, week);
                break;
            case 2:
                cron = String.format("0 %s %s %s * ?", minute, hour, day);
                break;
            default:
                cron = "0 0 0 * * ?";
                break;
        }

        return cron;
    }*/

    /**
     *  添加定时任务
     */
    private void addJob(BidList dto) {

        Long id = dto.getId();

        Map<String, Object> params = new HashMap<>();
        params.put("id", id);

        quartzManager.addJob(
                job_prefix + id,
                job_group_prefix + id,
                trigger_prefix + id,
                trigger_group_prefix + id,
                BidListJob.class, cronStr, params
        );
    }

    /**
     *  修改定时任务
     */
    public void modifyJob(BidList dto) {

        Long id = dto.getId();
        if (quartzManager.notExists(trigger_prefix + id, trigger_group_prefix + id)){
            // 任务不存在
            addJob(dto);
        } else {
            // 任务存在
            quartzManager.modifyJobTime(
                    trigger_prefix + id,
                    trigger_group_prefix + id,
                    cronStr
            );
        }
    }

    /**
     *  移除定时任务
     */
    public void removeJob(Long id) {
        quartzManager.removeJob(
                job_prefix + id,
                job_group_prefix + id,
                trigger_prefix + id,
                trigger_group_prefix + id
        );
    }
}
