package com.roy.routingDs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author roy
 * @desc
 */
@SpringBootApplication
@MapperScan("com.roy.routingDs.mapper")
public class DSApp {
    public static void main(String[] args) {
        SpringApplication.run(DSApp.class);
    }
}
