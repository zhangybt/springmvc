package com.product.service;

import com.product.entity.Person;
import com.product.entity.User;

import java.util.List;

/**
 * Created by zhangybt on 2017/5/22.
 */
public interface IUserCenterService {

    public List<Person> selectRelation(String adminPhone);

    public List<User> selectUsers();
}
