package com.autobid.job;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

// ���SpringBoot������Quartz��ע��Bean������
@Component
public class JobFactory extends AdaptableJobFactory {
    /**
     * AutowireCapableBeanFactory�ӿ���BeanFactory������
     * �������Ӻ������Щ�������ڲ���Spring������Ѵ��ڵ�beanʵ��
     */
    private AutowireCapableBeanFactory factory;

    public JobFactory(AutowireCapableBeanFactory factory) {
        this.factory = factory;
    }

    /**
     * ����Jobʵ��
     */
    @Override
    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {

        // ʵ��������
        Object job = super.createJobInstance(bundle);
        // ����ע�루Spring�����Bean��
        factory.autowireBean(job);
        //���ض���
        return job;
    }
}
