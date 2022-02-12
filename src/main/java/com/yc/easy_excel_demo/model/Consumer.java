package com.yc.easy_excel_demo.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author：YC
 * @date：2022/2/12
 * @description：客户实例 value表头设置 order顺序，从小到达排序
 * @version: 1.0.0
 */
@Data
@Builder
@HeadRowHeight(35) // 表头高度
@ContentRowHeight(25) // 内容高度
public class Consumer implements Serializable {
    /**
     * 名字
     */
    @ExcelProperty(value = {"客户信息", "名字"}, order = 1)
    // @ExcelIgnore 忽略写
    private String name;
    /**
     * 年龄
     */
    @ExcelProperty(value = {"客户信息", "年龄"}, order = 3)
    private int age;
    /**
     * 分数
     */
    @ExcelProperty(value = {"客户信息", "积分"}, order = 2)
    private int grade;
    /**
     * 生日
     */
    @ExcelProperty(value = {"客户信息", "生日"}, order = 2)
    @DateTimeFormat("yyyy-MM-dd")
    private Date date;
}
