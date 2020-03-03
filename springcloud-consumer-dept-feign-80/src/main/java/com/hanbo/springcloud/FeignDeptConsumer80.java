package com.hanbo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * ribbon和eureka整合之后，客户端可以直接调用，不用关心ip地址和端口号
 *
 * @author hanbo
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.hanbo.springcloud"})
public class FeignDeptConsumer80 {

    public static void main(String[] args) {
        SpringApplication.run(FeignDeptConsumer80.class, args);
    }

}
