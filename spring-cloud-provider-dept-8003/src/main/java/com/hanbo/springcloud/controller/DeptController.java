package com.hanbo.springcloud.controller;

import com.hanbo.springcloud.pojo.Dept;
import com.hanbo.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author hanbo
 * 提供restful服务
 */
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    /**
     * 获取一些信息
     */
    @Autowired
    private DiscoveryClient client;

    @PostMapping("/dept/add")
    public boolean addDept(Dept dept) {
        return deptService.addDept(dept);
    }

    @GetMapping("/dept/get/{id}")
    public Dept queryById(@PathVariable Long id) {
        return deptService.queryById(id);
    }

    @GetMapping("/dept/list")
    public List<Dept> queryAll() {
        return deptService.queryAll();
    }

    /**
     * 注册进来的微服务，获取一些消息
     *
     * @return Ob
     */
    @GetMapping("/dept/discovery")
    public Object discovery() {
        // 获取微服务列表的清单
        List<String> services = client.getServices();
        services.forEach(service -> System.out.println("discovery => services: " + service));

        client.getInstances("SPRINGCLOUD-PROVIDER-DEPT").forEach(instance ->
                System.out.println(String.join("\t", instance.getHost(), instance.getPort() + "", instance.getUri().toString(), instance.getServiceId()))
        );
        return this.client;
    }
}
