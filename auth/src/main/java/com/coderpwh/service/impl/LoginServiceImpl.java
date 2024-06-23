package com.coderpwh.service.impl;

import com.coderpwh.model.SecurityUser;
import com.coderpwh.model.TUser;
import com.coderpwh.service.LoginService;
import com.coderpwh.service.TRoleService;
import com.coderpwh.service.TUserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.List;
import java.util.Objects;
import org.springframework.lang.Nullable;

import javax.annotation.Resource;


@Service
public class LoginServiceImpl implements LoginService {



    @Resource
    private PasswordEncoder passwordEncoder;


    @Resource
    private TUserService tUserService;

    @Resource
    private TRoleService tRoleService;

    @Nullable
    @Override
    public SecurityUser loadByUsername(String username) {
        //获取用户信息
        TUser user = tUserService.getByUsername(username);
        if (Objects.nonNull(user)){
            SecurityUser securityUser = new SecurityUser();
            securityUser.setUsername(username);
            //todo 此处为了方便，直接在数据库存储的明文，实际生产中应该存储密文，则这里不用再次加密
            securityUser.setPassword(passwordEncoder.encode(user.getPassword()));
            //查询该用户的角色
            List<String> userRoles = tRoleService.selectAllByUsername(username);
            String[] a={};
            List<GrantedAuthority> authorityList = AuthorityUtils.createAuthorityList(userRoles.toArray(a));
            securityUser.setAuthorities(authorityList);
            return securityUser;
        }
        return null;
    }





}
