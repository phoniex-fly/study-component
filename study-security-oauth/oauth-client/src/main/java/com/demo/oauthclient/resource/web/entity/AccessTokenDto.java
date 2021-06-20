package com.demo.oauthclient.resource.web.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccessTokenDto {

    private String client_id;
    private String client_secret;
    private String grant_type;
    private String code;
    private String scope;
    private String redirect_uri;
    private String username;
    private String password;

}
