package com.coderpwh.service.impl;

import com.coderpwh.model.SecurityUser;
import com.coderpwh.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;


@Service
@Slf4j
public class JwtTokenUserDetailsService implements UserDetailsService {



    @Resource
    private LoginService loginService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SecurityUser securityUser = loginService.loadByUsername(username);
        log.info("securityUser:{}",securityUser);
        if(Objects.isNull(securityUser)){
            throw  new UsernameNotFoundException("用户不存在！");
        }
        return securityUser;
    }
}
