package com.hanbo.springcloud.controller;

import com.hanbo.springcloud.pojo.Dept;
import com.hanbo.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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

    @PostMapping("/dept/add")
    public boolean addDept(Dept dept) {
        return deptService.addDept(dept);
    }

    @HystrixCommand(fallbackMethod = "hystrixQueryById")
    @GetMapping("/dept/get/{id}")
    public Dept queryById(@PathVariable Long id) {
        Dept dept = deptService.queryById(id);
        if (dept == null) {
            throw new RuntimeException("id => " + id + "，不存在该用户");
        }
        return dept;
    }

    /**
     * 获取失败的备选方法
     * @param id
     * @return
     */
    public Dept hystrixQueryById(@PathVariable Long id) {
        return new Dept()
                .setId(id)
                .setName("id => " + id + "，不存在该用户, null => @hystrix")
                .setDbSource("no this database in MySql");
    }

    @GetMapping("/dept/list")
    public List<Dept> queryAll() {
        return deptService.queryAll();
    }

}
