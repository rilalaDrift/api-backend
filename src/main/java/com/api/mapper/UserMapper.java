package com.api.mapper;

import com.api.apicommon.model.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户数据库操作
 *

 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




