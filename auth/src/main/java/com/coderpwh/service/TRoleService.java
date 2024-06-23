package com.coderpwh.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.coderpwh.model.TRole;

import java.util.List;

/**
* @author life
* @description 针对表【t_role】的数据库操作Service
* @createDate 2024-01-20 13:28:28
*/
public interface TRoleService   {

    List<String> selectAllByUsername(String username);
}
