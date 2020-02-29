package com.hanbo.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author hanbo
 */
@Data
@Accessors(chain = true) // 链式写法
@NoArgsConstructor
public class Dept implements Serializable {

    private Long id;

    private String name;

    /**
     * 同一个信息可能存在不同的数据库
     */
    private String dbSource;

    public Dept(String name) {
        this.name = name;
    }
}
