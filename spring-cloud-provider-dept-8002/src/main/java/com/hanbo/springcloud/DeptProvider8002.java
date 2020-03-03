package com.hanbo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author hanbo
 */
@SpringBootApplication
@EnableEurekaClient // 在服务启动之后，自动注册到eureka中
@EnableDiscoveryClient
public class DeptProvider8002 {

    public static void main(String[] args) {
        SpringApplication.run(DeptProvider8002.class, args);
    }

}
