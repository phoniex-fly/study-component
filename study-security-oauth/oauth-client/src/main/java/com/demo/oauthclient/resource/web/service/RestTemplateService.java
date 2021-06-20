package com.demo.oauthclient.resource.web.service;


import com.demo.oauthclient.resource.web.entity.AccessTokenDto;
import com.demo.oauthclient.resource.web.entity.TokenDto;

/**
 * @author : Changyue.Liu
 * @Description: 描述
 * @date : 2019/10/9 14:21
 */
public interface RestTemplateService {

    public String authorize(String url, String... authorize);

    public TokenDto token(String url, AccessTokenDto accessToken);

}
