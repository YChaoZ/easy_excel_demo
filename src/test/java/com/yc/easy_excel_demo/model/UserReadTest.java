package com.yc.easy_excel_demo.model;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.yc.easy_excel_demo.listener.ExcelListener;
import org.junit.jupiter.api.Test;

/**
 * @author：YC
 * @date：2022/2/13
 * @description：用户文件读取测试类
 * @version: 1.0.0
 */
public class UserReadTest {
    @Test
    public void userReadTest() {
        // 写法1：
        String fileName = "用户示例.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(fileName, User.class, new ExcelListener()).sheet().doRead();

        // 写法2：
        fileName = "用户示例.xlsx";
        ExcelReader excelReader = EasyExcel.read(fileName, User.class, new ExcelListener()).build();
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        excelReader.read(readSheet);
        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        excelReader.finish();
    }
}
