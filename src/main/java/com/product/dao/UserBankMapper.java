package com.product.dao;

import com.product.entity.UserBank;

import java.util.List;

import com.product.entity.UserBankExample;
import com.product.entity.UserBankKey;
import org.apache.ibatis.annotations.Param;

public interface UserBankMapper {
    int countByExample(UserBankExample example);

    int deleteByExample(UserBankExample example);

    int deleteByPrimaryKey(UserBankKey key);

    int insert(UserBank record);

    int insertSelective(UserBank record);

    List<UserBank> selectByExample(UserBankExample example);

    UserBank selectByPrimaryKey(UserBankKey key);

    int updateByExampleSelective(@Param("record") UserBank record, @Param("example") UserBankExample example);

    int updateByExample(@Param("record") UserBank record, @Param("example") UserBankExample example);

    int updateByPrimaryKeySelective(UserBank record);

    int updateByPrimaryKey(UserBank record);
}