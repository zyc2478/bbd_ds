package com.autobid;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
//@ComponentScan({"com.autobid.controller","com.autobid.service","com.autobid.dao"})
@MapperScan(value="com.autobid.dao")
@RestController
@EnableAutoConfiguration
public class BBDDSBootApplication extends SpringBootServletInitializer {

    public static void main(String[] args){
        SpringApplication.run(BBDDSBootApplication.class, args);
        //URLClassLoader classLoader = (URLClassLoader)Main.class.getClassLoader();
        //System.out.println(Arrays.toString(classLoader.getURLs()));
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        PropertySourcesPlaceholderConfigurer c = new PropertySourcesPlaceholderConfigurer();
        c.setIgnoreUnresolvablePlaceholders(true);
        return c;
    }
}



