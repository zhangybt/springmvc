package com.product.dao;

import com.product.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by zhangybt on 2017/4/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/spring-*.xml"})
public class UserMapperTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserMapper userMapper;

    @Test
    public void insertUserBatch() throws Exception {
        long beginTime = System.currentTimeMillis();
        List<User> userList = new ArrayList<User>();
        for(int i=0;i<1;i++){
            User user = new User();
            user.setUserId(UUID.randomUUID().toString());
            user.setUserCode("zhangybt"+"00000"+(i+11));
            user.setUserName("zhangyanbin");
            user.setUserEmail("zhangybt@yonyou.com");
            user.setUserMobile("17778135772");
            user.setUserPassword("a123456");
            user.setUserStates(1);
            userList.add(user);
        }
        int result = userMapper.insertUserBatch(userList);
//        int result = userMapper.insert(user);
        logger.info("result={}", result);
        System.out.println("执行耗时："+(System.currentTimeMillis() - beginTime)/1000f+"秒");
    }

    @Test
    public void insert() throws Exception{
        long beginTime = System.currentTimeMillis();
        User user = new User();
        user.setUserId(UUID.randomUUID().toString());
        user.setUserCode("zhangybt"+"0001");
        user.setUserName("zhangyanbin");
        user.setUserEmail("zhangybt@yonyou.com");
        user.setUserMobile("17778135772");
        user.setUserPassword("a123456");
        user.setUserStates(1);
        userMapper.insert(user);
        System.out.println("执行耗时："+(System.currentTimeMillis() - beginTime)/1000f+"秒");
    }

    @Test
    public void insertSelective() throws Exception {

    }

    @Test
    public void selectByExample() throws Exception {

    }

    @Test
    public void selectByPrimaryKey() throws Exception {

    }

    @Test
    public void updateByExampleSelective() throws Exception {

    }

}