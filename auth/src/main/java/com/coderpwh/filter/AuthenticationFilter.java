package com.coderpwh.filter;


import cn.hutool.core.codec.Base64;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.coderpwh.model.LoginVal;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        String token = httpServletRequest.getHeader("token");

        if(token!=null){
            String json = Base64.decodeStr(token);
            JSONObject jsonObject = JSONObject.parseObject(json);

            String principal = jsonObject.getString("user_name");

            JSONArray tempJsonArray =  jsonObject.getJSONArray("authorities");

            String[]  authorites =tempJsonArray.toArray(new String[0]);

            LoginVal loginVal =  new LoginVal();

            loginVal.setUsername(principal);
            loginVal.setAuthorities(authorites);

            httpServletRequest.setAttribute("login_message",loginVal);
        }

        filterChain.doFilter(httpServletRequest,httpServletResponse);

    }


}
