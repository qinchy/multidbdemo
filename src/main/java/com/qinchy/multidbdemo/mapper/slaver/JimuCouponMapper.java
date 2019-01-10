package com.qinchy.multidbdemo.mapper.slaver;

import com.qinchy.multidbdemo.domain.slaver.JimuCoupon;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface JimuCouponMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(JimuCoupon record);

    int insertSelective(JimuCoupon record);

    JimuCoupon selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JimuCoupon record);

    int updateByPrimaryKey(JimuCoupon record);
}