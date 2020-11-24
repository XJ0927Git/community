package com.zhaoguojiang.community.community.mapper;

import com.zhaoguojiang.community.community.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: xj0927
 * @Description:
 * @Date Created in 2020-11-24 10:06
 * @Modified By:
 */
class UserMapperTest {
    @Autowired
    private UserMapper mapper;

    @Test
    void insert() {
        User user = new User();
        user.setName("小名");
        mapper.insert(user);
    }
}