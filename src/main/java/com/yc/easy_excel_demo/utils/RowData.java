package com.yc.easy_excel_demo.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author：YC
 * @date：2022/2/13
 * @description：Excel行数据
 * @version: 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RowData {
    //行数
    private Integer rowIndex;

    //excel导入转换后实体类
    private Object data;
}
