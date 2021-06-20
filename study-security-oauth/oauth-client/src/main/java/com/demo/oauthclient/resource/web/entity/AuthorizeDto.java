package com.demo.oauthclient.resource.web.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorizeDto {

    private String client_id;
    private String client_secret;
    private String response_type;
    private String scope;
    private String redirect_uri;
    private String state;
}
