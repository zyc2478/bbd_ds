package com.autobid;

import javafx.application.Application;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;
import sun.tools.jar.Main;

import java.net.URLClassLoader;
import java.util.Arrays;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
//@ComponentScan({"com.autobid.controller","com.autobid.service","com.autobid.dao"})
@MapperScan(value="com.autobid.dao")
@RestController
@EnableAutoConfiguration
public class BBDDSBootApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BBDDSBootApplication.class);
    }

    public static void main(String[] args){
        SpringApplication.run(BBDDSBootApplication.class, args);
        //URLClassLoader classLoader = (URLClassLoader)Main.class.getClassLoader();
        //System.out.println(Arrays.toString(classLoader.getURLs()));
    }
}

