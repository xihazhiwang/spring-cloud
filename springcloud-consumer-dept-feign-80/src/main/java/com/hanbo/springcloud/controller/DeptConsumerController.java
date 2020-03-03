package com.hanbo.springcloud.controller;

import com.hanbo.springcloud.pojo.Dept;
import com.hanbo.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author hanbo
 * 消费者没有service
 * RestFul
 * <p>
 * url, 实
 */
@RestController
public class DeptConsumerController {

    @Autowired
    private DeptClientService service;

    @GetMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable Long id) {
        return this.service.queryById(id);
    }

    @GetMapping("/consumer/dept/add")
    public Boolean add(Dept dept) {
        return this.service.addDept(dept);
    }

    @GetMapping("/consumer/dept/list")
    public List<Dept> list() {
        return this.service.queryAll();
    }
}
