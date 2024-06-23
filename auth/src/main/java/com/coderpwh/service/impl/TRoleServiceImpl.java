package com.coderpwh.service.impl;

import com.coderpwh.mapper.TRoleMapper;
import com.coderpwh.service.TRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * @author life
 * @description 针对表【t_role】的数据库操作Service实现
 * @createDate 2024-01-20 13:28:28
 */
@Service
public class TRoleServiceImpl
        implements TRoleService {

    @Autowired
    TRoleMapper tRoleMapper;

    @Override
    public List<String> selectAllByUsername(String username) {
        return tRoleMapper.selectAllByUserName(username);
    }
}






