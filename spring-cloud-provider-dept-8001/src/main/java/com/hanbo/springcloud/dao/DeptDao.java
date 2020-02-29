package com.hanbo.springcloud.dao;

import com.hanbo.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author hanbo
 */
@Mapper
public interface DeptDao {

    /**
     * 增加部门
     *
     * @param dept
     * @return
     */
    boolean addDept(Dept dept);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    Dept queryById(Long id);

    /**
     * @return List
     */
    List<Dept> queryAll();
}
