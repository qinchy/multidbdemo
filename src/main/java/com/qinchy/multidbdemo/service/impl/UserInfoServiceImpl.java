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

@Service
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
}
