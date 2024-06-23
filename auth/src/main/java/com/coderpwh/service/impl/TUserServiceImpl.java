package com.coderpwh.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coderpwh.mapper.TUserMapper;
import com.coderpwh.model.TUser;
import com.coderpwh.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author life
 * @description 针对表【t_user】的数据库操作Service实现
 * @createDate 2024-01-20 13:00:58
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser>
        implements TUserService {


    @Resource
    private TUserMapper tUserMapper;

    @Override
    public TUser getByUsername(String username) {
        return tUserMapper.selectOneByUsername(username);
    }
}




