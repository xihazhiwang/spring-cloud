package com.hanbo.springcloud.service;

import com.hanbo.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 服务降级
 */
@Component
public class DeptClientServiceFallBackFactory implements FallbackFactory {

    @Override
    public Object create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public boolean addDept(Dept dept) {
                return false;
            }

            @Override
            public Dept queryById(Long id) {
                return new Dept().setId(id)
                        .setName("这个id => " + id + "没有对应的信息，客户端提供了降级的信息，这个服务已经被关闭")
                        .setDbSource("没有数据");
            }

            @Override
            public List<Dept> queryAll() {
                return new ArrayList<>();
            }
        };
    }
}
