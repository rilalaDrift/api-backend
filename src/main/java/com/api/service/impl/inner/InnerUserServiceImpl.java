package com.api.service.impl.inner;


import com.api.apicommon.model.entity.User;
import com.api.apicommon.service.InnerUserService;
import com.api.common.ErrorCode;
import com.api.exception.BusinessException;
import com.api.mapper.UserMapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;

import org.springframework.beans.factory.annotation.Autowired;

@DubboService
public class InnerUserServiceImpl implements InnerUserService {
    @Autowired
    private UserMapper userMapper;

    //获得用户
    @Override
    public User getInvokeUser(String accessKey) {
        if (StringUtils.isAnyBlank(accessKey)){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("accessKey",accessKey);
        return   userMapper.selectOne(queryWrapper);
    }
}
