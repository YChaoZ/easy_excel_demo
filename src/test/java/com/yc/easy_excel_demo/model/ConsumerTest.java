package com.yc.easy_excel_demo.model;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

/**
 * @author：YC
 * @date：2022/2/12
 * @description：复杂条件测试类
 * @version: 1.0.0
 */
@SpringBootTest
public class ConsumerTest {

    public List<Consumer> getConsumer() {
        List<Consumer> consumers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Consumer user = Consumer.builder().name("YC").age(i).grade(50 + i).date(new Date()).build();
            consumers.add(user);
        }
        return consumers;
    }

    @Test
    public void easyExcelTest() {
        EasyExcel.write("客户示例.xlsx", Consumer.class)
                .sheet("客户示例").doWrite(getConsumer());
    }


    /**
     * 特定内容写出
     */
    @Test
    public void assignTest() {
        Set<String> set = new HashSet<>();
        set.add("name");
        set.add("age");


        EasyExcel.write("客户示例.xlsx", Consumer.class).includeColumnFiledNames(set)
                // 自适应长度，非精确匹配
                .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())
                .sheet("客户示例").doWrite(getConsumer());
    }
}