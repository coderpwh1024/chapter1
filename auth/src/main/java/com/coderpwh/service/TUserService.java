package com.coderpwh.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.coderpwh.model.TUser;

/**
* @author life
* @description 针对表【t_user】的数据库操作Service
* @createDate 2024-01-20 13:00:58
*/
public interface TUserService extends IService<TUser> {

    TUser getByUsername(String username);
}
