package com.roy.shardingDemo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.roy.shardingDemo.entity.User;
import com.roy.shardingDemo.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chenxuegui
 * @since 2025/3/11
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class 读写分离Test {

    @Resource
    private UserMapper userMapper;

    @Test
    public void addUser(){
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setUsername("user"+i);
            user.setPassword("123qweasd");
            user.setUserstatus("NORMAL");
            user.setAge(30+i);
            user.setSex(i%2==0?"F":"M");

            userMapper.insert(user);
        }
    }

    /**
     * 查询用户测试：
     *  根据userid进行SQL路由
     *  读写分离测试
     */
    @Test
    public void queryUser() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("userid","1644954727911317506");
        queryWrapper.eq("password","123qweasd");
        List<User> users = userMapper.selectList(queryWrapper);
        for(User user : users){
            System.out.println(user);
        }
    }
}
