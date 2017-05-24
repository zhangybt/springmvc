package com.product.dao;

import com.product.entity.Seckill;
import com.product.entity.SeckillExample;
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
public class SeckillMapperTest {

    private Logger logger = LoggerFactory.getLogger(SeckillMapperTest.class);

    @Autowired
    private SeckillMapper seckillMapper;

    @Test
    public void selectByPrimaryKey() throws Exception {
        long condition = 1000L;
        Seckill seckill = seckillMapper.selectByPrimaryKey(condition);
        logger.info("seckill={}" + seckill);
    }

    @Test
    public void selectByExample() throws Exception {
        SeckillExample seckillExample = new SeckillExample();
        SeckillExample.Criteria criteria = seckillExample.createCriteria();
        criteria.andSeckillIdEqualTo(1000L);
        seckillExample.setDistinct(true);
        seckillExample.setOrderByClause("seckill_id asc");
        List<Seckill> seckill = seckillMapper.selectByExample(seckillExample);
        logger.info("seckill={}" + seckill);
    }

}