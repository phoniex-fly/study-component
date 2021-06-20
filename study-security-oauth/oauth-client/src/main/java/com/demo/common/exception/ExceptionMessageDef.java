package com.demo.common.exception;


public interface ExceptionMessageDef {

    int NULL_LOGIN_INFO = 40000;
    String NULL_LOGIN_INFO_MSG = "没有登录信息";

    int NULL_PARAM = 40010;
    String NULL_PARAM_MSG = "非法用户";

    int ILLEGAL_PARAMETER_CODE = 40010;
    String ILLEGAL_PARAMETER_MSG = "非法用户";

    int QUERY_PARAM_ERROR = 40011;
    String QUERY_PARAM_ERROR_MSG = "非法参数";

    int QUERY_USER_ERROR = 40012;
    String QUERY_USER_ERROR_MSG = "系统无此用户";

    int USER_STATUS_ERROR = 40013;
    String USER_STATUS_MSG = "用户已离职";

    int PASSWORD_ERROR = 40014;
    String PASSWORD_ERROR_MSG = "密码校验失败！";

    int USER_LOCKED = 40015;
    String USER_LOCKED_MSG = "用户已被锁定！";

    int CHANGE_PASSWORD = 40016;
    String CHANGE_PASSWORD_MSG = "密码安全性较低！";

    int REPEAT_RESULT = 40017;
    String REPEAT_RESULT_MSG = "返回多个结果！";

    int CAPTCHA_TIME_OUT = 40018;
    String CAPTCHA_TIME_OUT_MSG = "验证码超时！";

    int CAPTCHA_NULL = 40019;
    String CAPTCHA_NULL_MSG = "验证码为空！";

    int CAPTCHA_ERROR = 40020;
    String CAPTCHA_ERROR_MSG = "验证码错误！";

    int IP_DIFFERENT = 40031;
    String IP_DIFFERENT_MSG = "两次操作IP不同！";


    int SIGN_IN_ERROR = 40040;
    String SIGN_IN_ERROR_MSG = "登陆信息异常";

    int OPERATION_ERROR = 40041;
    String OPERATION_ERROR_MSG = "操作异常";

    int OPERATION_TIME_OUT = 40042;
    String OPERATION_TIME_OUT_MSG = "操作超时";

    int REST_ERROR = 40050;
    String REST_ERROR_MSG = "调用失败";

    int EXCEED_LOGIN_TIMES = 40061;
    String EXCEED_LOGIN_TIMES_MSG = "用户被限制登录";

    int FORBIDDEN_TIME = 40062;
    String FORBIDDEN_TIME_MSG = "超过最大登录次数";

    int SMS_TIMES = 40063;
    String SMS_TIMES_MSG = "发送短信验证码超过今天最大次数";

    int OAUTH_CLIENT_EMPTY = 40070;
    String OAUTH_CLIENT_EMPTY_MSG = "客户标识为空";

    int OAUTH_CLIENT_ERROR = 40071;
    String OAUTH_CLIENT_ERROR_MSG = "非法的client标识";

    int OAUTH_STATE_ERROR = 40072;
    String OAUTH_STATE_ERROR_MSG = "无效的请求";

}
