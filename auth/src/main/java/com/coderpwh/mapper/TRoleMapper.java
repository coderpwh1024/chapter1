package com.coderpwh.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.model.TRole;

import java.util.List;

/**
* @author life
* @description 针对表【t_role】的数据库操作Mapper
* @createDate 2024-01-20 13:28:28
* @Entity org.example.model.TRole
*/
@Mapper
public interface TRoleMapper extends BaseMapper<TRole> {
    List<TRole> selectAllByName(@Param("name") String name);

    List<String> selectAllByUserName(@Param("username") String username);

}




