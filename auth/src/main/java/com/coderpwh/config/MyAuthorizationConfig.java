package com.coderpwh.config;


import javax.annotation.Resource;

import jdk.nashorn.internal.parser.TokenStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.InMemoryAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

@Configuration
@EnableAuthorizationServer
public class MyAuthorizationConfig extends AuthorizationServerConfigurerAdapter {


    @Resource
    private TokenStore tokenStore;

    /**
     * 客户端存储策略，这里使用内存方式，后续可以存储在数据库
     */
    @Resource
    private ClientDetailsService clientDetailsService;

    /**
     * Security的认证管理器，密码模式需要用到
     */
    @Resource
    private AuthenticationManager authenticationManager;


    @Resource
    private JwtAccessTokenConverter jwtAccessTokenConverter;


    /***
     * 配置令牌访问的安全配置
     *  tokenKeyAccess: 开启 oauth/token_key 验证端口权限访问
     *  checkTokenAccess: 开启/oauth/check_token 验证端口认证权限
     *  allowFormAuthenticationForClients： 表示支持client_id和client_secret 做登录认证
     *
     * @param securityConfigurer
     */
    public void configure(AuthorizationServerSecurityConfigurer securityConfigurer) {
        securityConfigurer
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("permitAll()")
                .allowFormAuthenticationForClients();
    }


    /***
     * 配置客户端模式
     * @param clients
     */
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

        //内存模式
        clients.inMemory()
                //客户端id
                .withClient("test")
                //客户端秘钥
                .secret(new BCryptPasswordEncoder().encode("123456"))
                //资源id，唯一，比如订单服务作为一个资源,可以设置多个
                .resourceIds("order")
                //授权模式，总共四种，1. authorization_code（授权码模式）、password（密码模式）、client_credentials（客户端模式）、implicit（简化模式）
                //refresh_token并不是授权模式，
                .authorizedGrantTypes("authorization_code", "password", "client_credentials", "implicit", "refresh_token")
                //允许的授权范围，客户端的权限，这里的all只是一种标识，可以自定义，为了后续的资源服务进行权限控制
                .scopes("all")
                //false 则跳转到授权页面
                .autoApprove(false)
                //授权码模式的回调地址 ,可以and继续添加客户端
                .redirectUris("http://www.baidu.com");
    }




}
