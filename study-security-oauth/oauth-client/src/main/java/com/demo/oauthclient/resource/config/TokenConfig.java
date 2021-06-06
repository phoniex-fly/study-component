package com.demo.oauthclient.resource.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * 远程token验证
 */
@Configuration
public class TokenConfig {

    /**
     * 使用远程服务请求授权服务器校验token,必须指定校验token 的url、client_id，client_secret
     *
     * @return
     */
//    @Bean
//    public ResourceServerTokenServices remoteTokenService() {
//        RemoteTokenServices service = new RemoteTokenServices();
//        service.setCheckTokenEndpointUrl("http://localhost:9999/oauth/check_token");
//        service.setClientId("myclient");
//        service.setClientSecret("123456");
//        return service;
//    }

//    @Bean
//    public ResourceServerTokenServices defaulTokenService() {
//        DefaultTokenServices service = new DefaultTokenServices();
//        return service;
//    }


    /**
     * 使用本地服务检验token
     *
     * @return
     */
//    @Bean
//    public TokenStore tokenStore() {
//        return new JwtTokenStore(jwtAccessTokenConverter());
//    }

    /**
     * 与授权服务器使用共同的密钥进行解析
     */
//    @Bean
//    public JwtAccessTokenConverter jwtAccessTokenConverter() {
//        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//        converter.setSigningKey("和认证服务一样的signkey");
//        return converter;
//    }

}
