package com.roy.dsframework;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author roy
 * @date 2022/3/20
 * @desc
 */
@SpringBootApplication
@MapperScan("com.roy.dsframework.mapper")
public class DSFrameworkApp {

    public static void main(String[] args) {
        SpringApplication.run(DSFrameworkApp.class,args);
    }
}
