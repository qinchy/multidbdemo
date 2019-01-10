package com.qinchy.multidbdemo.mapper.master;

import com.qinchy.multidbdemo.domain.master.SaasUserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SaasUserInfoMapper {
    int deleteByPrimaryKey(String userId);

    int insert(SaasUserInfo record);

    int insertSelective(SaasUserInfo record);

    SaasUserInfo selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(SaasUserInfo record);

    int updateByPrimaryKey(SaasUserInfo record);
}