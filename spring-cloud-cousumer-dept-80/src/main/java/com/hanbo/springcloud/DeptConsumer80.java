package com.hanbo.springcloud;

import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import java.util.Random;

/**
 * ribbon和eureka整合之后，客户端可以直接调用，不用关心ip地址和端口号
 *
 * @author hanbo
 */
@SpringBootApplication
@EnableEurekaClient
// 在微服务启动的时候，就能加载我们自定义的ribbon类
@RibbonClient(name = "SPRINGCLOUD-PROVIDER-DEPT", configuration = RandomRule.class)
public class DeptConsumer80 {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer80.class, args);
    }

}
