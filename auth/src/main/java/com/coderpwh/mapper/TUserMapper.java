package com.coderpwh.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.coderpwh.model.TUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @author life
* @description 针对表【t_user】的数据库操作Mapper
* @createDate 2024-01-20 13:00:58
* @Entity org.example.model.TUser
*/
@Mapper
public interface TUserMapper extends BaseMapper<TUser> {
    TUser selectOneByUsername(@Param("username") String username);

}




