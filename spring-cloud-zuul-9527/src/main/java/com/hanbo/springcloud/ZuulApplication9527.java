package com.hanbo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient  // 在服务启动之后，自动注册到eureka中
public class ZuulApplication9527 {

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication9527.class, args);
    }

}
