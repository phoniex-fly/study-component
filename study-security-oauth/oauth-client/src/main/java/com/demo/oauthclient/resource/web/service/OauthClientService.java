package com.demo.oauthclient.resource.web.service;

import javax.servlet.ServletException;
import java.io.IOException;

public interface OauthClientService {

    String comeToOauth(String client, String target, String mark);

    void callBack(String code, String state) throws IOException, ServletException;
}
