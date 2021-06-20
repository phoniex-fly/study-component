package com.demo.oauthclient.resource.web.service.impl;


import cn.hutool.json.JSONUtil;
import com.demo.oauthclient.resource.web.entity.AccessTokenDto;
import com.demo.oauthclient.resource.web.entity.TokenDto;
import com.demo.oauthclient.resource.web.service.RestTemplateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestTemplateServiceImpl implements RestTemplateService {

    private Logger logger = LoggerFactory.getLogger("InterfaceLogger");

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public String authorize(String url, String... authorize) {
        logger.info("请求对接方授权url:{},请求参数{}", url, JSONUtil.toJsonStr(authorize));
        String forObject = restTemplate.getForObject(url, String.class, authorize);
        logger.info("请求对接方授权返回内容：{}", forObject);
        return forObject;
    }

    @Override
    public TokenDto token(String url, AccessTokenDto accessToken) {
        logger.info("请求对接方token-url:{},请求参数", url, JSONUtil.toJsonStr(accessToken));
        TokenDto token = restTemplate.getForObject(url, TokenDto.class, accessToken);
        logger.info("请求对接方授权返回内容：{}", JSONUtil.toJsonStr(token));
        return token;
    }


}
