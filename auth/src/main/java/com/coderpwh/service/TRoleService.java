package com.coderpwh.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.coderpwh.model.TRole;
import com.coderpwh.model.TUser;

import java.util.List;

public interface TRoleService  extends IService<TRole>  {

    List<String> selectAllByUsername(String username);
}
