package com.autobid.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class MyFirstExerciseJob {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public void myJobBusinessMethod() {
        this.logger.info("�ۣ������ϴ󣬱������˹���������");
    }

}