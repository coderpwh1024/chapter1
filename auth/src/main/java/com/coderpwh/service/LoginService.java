package com.coderpwh.service;

import com.coderpwh.model.SecurityUser;

public interface LoginService {

    /**
     * 根据用户名查找
     */
    SecurityUser loadByUsername(String username);
}
