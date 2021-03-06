package com.product.service;

import com.product.entity.Person;
import com.product.entity.Seckill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by zhangybt on 2017/4/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/spring-*.xml"})
public class SeckillServiceTest {

    private final static Logger logger = LoggerFactory.getLogger(SeckillServiceTest.class);

    @Autowired
    private SeckillService seckillService;

    @Autowired
    private IUserCenterService userCenterService;

    @Test
    public void selectByPrimaryKey() throws Exception {
        long id = 1000L;
        Seckill seckill = seckillService.selectByPrimaryKey(id);
        logger.info("seckill={}", seckill);

    }

    @Test
    public void selectTenantInfo(){
        String phone = "13920170000";
        List<Person> result = userCenterService.selectRelation(phone);
        System.out.println(result);
    }

}