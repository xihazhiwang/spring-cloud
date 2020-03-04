package com.hanbo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard // 开启dashboard
public class DeptConsumerDashboard9001 {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerDashboard9001.class, args);
    }

}
