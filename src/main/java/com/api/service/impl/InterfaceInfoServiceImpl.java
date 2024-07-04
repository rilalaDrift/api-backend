package com.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.api.common.ErrorCode;
import com.api.exception.BusinessException;
import com.api.exception.ThrowUtils;
import com.api.apicommon.model.entity.InterfaceInfo;
import com.api.service.InterfaceInfoService;
import com.api.mapper.InterfaceInfoMapper ;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
*
*/
@Service
public class InterfaceInfoServiceImpl extends ServiceImpl<InterfaceInfoMapper, InterfaceInfo>
    implements InterfaceInfoService {

    public void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add) {
        if (interfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        String name = interfaceInfo.getName();

        // 创建时，参数不能为空
        if (add) {
            ThrowUtils.throwIf(StringUtils.isAnyBlank(name), ErrorCode.PARAMS_ERROR);
        }
        // 有参数则校验
        if (StringUtils.isNotBlank(name) && name.length() >50) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "名称过长");
        }

    }

}




