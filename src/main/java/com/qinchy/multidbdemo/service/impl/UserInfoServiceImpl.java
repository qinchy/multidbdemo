package com.qinchy.multidbdemo.service.impl;

import com.qinchy.multidbdemo.domain.master.SaasUserInfo;
import com.qinchy.multidbdemo.domain.slaver.JimuCoupon;
import com.qinchy.multidbdemo.mapper.master.SaasUserInfoMapper;
import com.qinchy.multidbdemo.mapper.slaver.JimuCouponMapper;
import com.qinchy.multidbdemo.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService {

    private Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    @Autowired
    private SaasUserInfoMapper saasUserInfoMapper;

    @Autowired
    private JimuCouponMapper jimuCouponMapper;

    @Override
    public boolean getUserInfo() {
        SaasUserInfo saasUserInfo = saasUserInfoMapper.selectByPrimaryKey("001139819");
        if (null != saasUserInfo) {
            logger.info("姓名：" + saasUserInfo.getUserName());
        }

        JimuCoupon jimuCoupon = jimuCouponMapper.selectByPrimaryKey(26);
        if (null != jimuCoupon) {
            logger.info("面额：" + jimuCoupon.getEarn());
        }
        return true;
    }

    @Override
    public boolean saveUserInfo() {
        JimuCoupon record0 = new JimuCoupon();
        record0.setEarn(new BigDecimal(1));
        record0.setMonth(12);
        record0.setTotal(100);
        record0.setValid(1);
        jimuCouponMapper.insert(record0);

        // 这里特意模拟报错，上面的语句可以插入数据库，下面的报错，最终两个库都是失败，达到分布式事务目的
        SaasUserInfo record1 = new SaasUserInfo();
        saasUserInfoMapper.insert(record1);

        return true;
    }
}
