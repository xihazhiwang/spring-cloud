package com.hanbo.springcloud.service;

import com.hanbo.springcloud.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Component
@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT")
public interface DeptClientService {

    @GetMapping("/dept/get/{id}")
    boolean addDept(@PathVariable("id") Dept dept);

    @PostMapping("/dept/add")
    Dept queryById(Long id);

    @GetMapping("/dept/list")
    List<Dept> queryAll();

}
