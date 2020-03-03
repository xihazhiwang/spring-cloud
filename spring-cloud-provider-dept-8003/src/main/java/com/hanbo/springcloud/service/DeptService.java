package com.hanbo.springcloud.service;

import com.hanbo.springcloud.pojo.Dept;

import java.util.List;

/**
 * @author hanbo
 */
public interface DeptService {

    /**
     * 增加部门
     * @return
     */
    boolean addDept(Dept dept);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Dept queryById(Long id);

    /**
     *
     * @return
     */
    List<Dept> queryAll();

}
