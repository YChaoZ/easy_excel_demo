package com.yc.easy_excel_demo.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author：YC
 * @date：2022/2/12
 * @description：用户示例
 * @version: 1.0.0
 */
@Data
@Builder
public class User implements Serializable {
    /**
     * 名字
     */
    private String name;
    /**
     * 年龄
     */
    private int age;
    /**
     * 分数
     */
    private int grade;
}
