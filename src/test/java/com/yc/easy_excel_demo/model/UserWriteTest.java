package com.yc.easy_excel_demo.model;

import com.alibaba.excel.EasyExcel;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author：YC
 * @date：2022/2/12
 * @description：简单条件测试类
 * @version: 1.0.0
 */
@SpringBootTest
public class UserWriteTest {
    @PostConstruct
    public List<User> getUser() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = User.builder().name("YC").age(i).grade(50 + i).build();
            users.add(user);
        }
        return users;
    }

    @Test
    public void easyExcelTest() {
        EasyExcel.write("用户示例.xlsx", User.class).sheet("用户示例").doWrite(getUser());
    }
}