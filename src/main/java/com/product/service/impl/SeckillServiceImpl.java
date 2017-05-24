package com.product.service.impl;

import com.product.dao.SeckillMapper;
import com.product.entity.Seckill;
import com.product.entity.SeckillExample;
import com.product.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhangybt on 2017/4/25.
 */
@Service
public class SeckillServiceImpl implements SeckillService {

    @Autowired
    private SeckillMapper seckillMapper;

    public Seckill selectByPrimaryKey(long id) {
        return seckillMapper.selectByPrimaryKey(id);
    }

    public List<Seckill> selectByExample() {
        SeckillExample seckillExample = new SeckillExample();
        seckillExample.setDistinct(true);
        seckillExample.setOrderByClause("seckill_id desc");
        return seckillMapper.selectByExample(seckillExample);
    }
}
