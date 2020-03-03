package com.hanbo.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author hanbo
 */
@Configuration // = spring-application.xml
public class ConfigBean {

    // AvailabilityFilteringRule: 会先过滤掉一部分故障应用（延迟高，宕机），对剩下的进行轮询
    // RetryRule： 会先按照轮询获取服务，如果服务获取失败，则会在固定的时间内进行重试
    // RoundRobinRule: 轮询
    // RandomRule: 随机
    @Bean
    @LoadBalanced // ribbon 配置负载均衡实现restTemplate
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
