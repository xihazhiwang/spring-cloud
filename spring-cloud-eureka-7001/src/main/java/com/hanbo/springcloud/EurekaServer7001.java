package com.hanbo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author hanbo
 */
@SpringBootApplication
@EnableEurekaServer // eureka服务端的启动累，可以接受其他项目
public class EurekaServer7001 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer7001.class, args);
    }

}
