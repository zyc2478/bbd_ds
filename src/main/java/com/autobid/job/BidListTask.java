package com.autobid.job;

import com.autobid.model.BidList;
import org.assertj.core.util.Maps;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BidListTask {
    // ������ǰ׺
    private final String job_prefix = "job_";
    // ������ǰ׺
    private final String job_group_prefix = "job_group_";
    // ������ǰ׺
    private final String trigger_prefix = "trigger_";
    // ������ǰ׺
    private final String trigger_group_prefix = "trigger_group_";

    @Value("${job.cron}")
    private String cronStr;

    private QuartzManager quartzManager;

    public BidListTask(QuartzManager quartzManager) {
        this.quartzManager = quartzManager;
    }

/*    *//**
     *  ������������cron���ʽ
     *//*
    private String getCron(SftpDTO dto) {

        // ʱ
        Integer hour = dto.getHour();
        // ��
        Integer minute = dto.getMinute();
        // ÿ�ܼ�
        Integer week = dto.getWeek();
        // ÿ�¼���
        Integer day = dto.getDay();

        *//* ִ��ʱ�� 0ÿ��,1ÿ��,2ÿ�� *//*
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
     *  ��Ӷ�ʱ����
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
     *  �޸Ķ�ʱ����
     */
    public void modifyJob(BidList dto) {

        Long id = dto.getId();
        if (quartzManager.notExists(trigger_prefix + id, trigger_group_prefix + id)){
            // ���񲻴���
            addJob(dto);
        } else {
            // �������
            quartzManager.modifyJobTime(
                    trigger_prefix + id,
                    trigger_group_prefix + id,
                    cronStr
            );
        }
    }

    /**
     *  �Ƴ���ʱ����
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
