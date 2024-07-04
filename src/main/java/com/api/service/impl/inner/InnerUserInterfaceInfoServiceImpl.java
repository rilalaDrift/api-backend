package com.api.service.impl.inner;

import com.api.apicommon.service.InnerUserInterfaceInfoService;
import com.api.service.UserInterfaceInfoService;
import org.apache.dubbo.config.annotation.DubboService;


import javax.annotation.Resource;

/**
 * 内部用户接口信息服务实现类
 */
@DubboService
public class InnerUserInterfaceInfoServiceImpl implements InnerUserInterfaceInfoService {
    @Resource
    private UserInterfaceInfoService userInterfaceInfoService;
    @Override
    //是否更新成功，使用次数和余额更新
    public boolean invokeCount(long interfaceInfoId, long userId) {
        return userInterfaceInfoService.invokeCount(interfaceInfoId,userId);
    }
}
