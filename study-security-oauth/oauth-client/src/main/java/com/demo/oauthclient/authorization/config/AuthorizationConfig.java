package com.demo.oauthclient.authorization.config;

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
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * 授权服务器
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationConfig extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private AuthorizationCodeServices authorizationCodeServices;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private AuthorizationServerTokenServices tokenServices;


    /**
     * 用来配置客户端详情服务（ClientDetailsService），
     * 客户端详情信息在 这里进行初始化，
     * 你能够把客户端详情信息写死在这里或者是通过数据库来存储调取详情信息
     *
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        /**
         * ClientDetailsServiceConfigurer 能够使用内存或者JDBC来实现客户端详情服务（ClientDetailsService），
         * ClientDetailsService负责查找ClientDetails，而ClientDetails有几个重要的属性如下列表：
         *          clientId：（必须的）用来标识客户的Id。
         *      secret：（需要值得信任的客户端）客户端安全码，如果有的话。
         *      scope：用来限制客户端的访问范围，如果为空（默认）的话，那么客户端拥有全部的访问范围。
         *      authorizedGrantTypes：此客户端可以使用的授权类型，默认为空。
         *      authorities：此客户端可以使用的权限（基于Spring Security authorities）。
         *
         * 客户端详情（Client Details）能够在应用程序运行的时候进行更新，
         * 可以通过访问底层的存储服务（例如将客户 端详情存储在一个关系数据库的表中，
         * 就可以使用 JdbcClientDetailsService）或者通过自己实现 ClientRegistrationService接口
         * （同时你也可以实现 ClientDetailsService 接口）来进行管理
         */
        // clients.withClientDetails(clientDetailsService);
        /**
         * 暂时使用内存方式存储客户端详情信息
         */
        clients.inMemory()// 使用in‐memory存储
                .withClient("client")// client_id
                .secret(new BCryptPasswordEncoder().encode("123456"))
//                .resourceIds("res_01")//资源服务ID
                .authorizedGrantTypes("authorization_code", "password", "client_credentials", "implicit", "refresh_token")// 该client允许的授权类型 authorization_code,password,refresh_token,implicit,client_credentials
                .scopes("all")// 允许的授权范围
                .autoApprove(true)//false为手动授权 true为自动授权
                .redirectUris("http://localhost:18180/oauthServerTest/oauthClient/callBack");//加上验证回调地址
    }

    /**
     * 用来配置令牌（token）的访问端点和令牌服务(token services)
     *
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager)
                .authorizationCodeServices(authorizationCodeServices)
                .tokenServices(tokenServices)
                .allowedTokenEndpointRequestMethods(HttpMethod.POST);
    }


    /**
     * 用来配置令牌端点的安全约束
     *
     * @param security
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()")//tokenkey这个endpoint当使用JwtToken且使用非对称加密时，资源服务用于获取公钥而开放的，这里指这个 endpoint完全公开。
                .checkTokenAccess("permitAll()")//checkToken这个endpoint完全公开
                .allowFormAuthenticationForClients();//允许表单认证
    }
}
