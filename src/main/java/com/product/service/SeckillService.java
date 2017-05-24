package com.product.service;

import com.product.entity.Seckill;

import java.util.List;

/**
 * Created by zhangybt on 2017/4/25.
 */
public interface SeckillService {

    public Seckill selectByPrimaryKey(long id);

    public List<Seckill> selectByExample();
}
