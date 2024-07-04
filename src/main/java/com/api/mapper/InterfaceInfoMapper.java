package com.api.mapper;

import com.api.apicommon.model.entity.InterfaceInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 26987
* @description 针对表【interface_info(接口信息)】的数据库操作Mapper
* @createDate 2023-11-21 15:31:59
* @Entity com.project.model.entity.InterfaceInfo
*/
@Mapper
public interface InterfaceInfoMapper extends BaseMapper<InterfaceInfo> {

}




