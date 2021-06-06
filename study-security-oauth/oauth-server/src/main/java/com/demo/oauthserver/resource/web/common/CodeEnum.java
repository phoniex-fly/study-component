package com.demo.oauthserver.resource.web.common;

public enum  CodeEnum {
    CODE_OK_0(0, "Success"),
    CODE_OK(200, "OK"),
    CODE_FAIL(-1, "操作失败"),
    CODE_RPC_ERROR(-2, "远程调度失败"),
    CODE_UNKNOWN(-3, "未知错误"),
    CODE_REDIS_ERROR(-4, "存储redis错误"),
    CODE_CPBEAN_ERROR(-5, "复制bean失败"),
    CODE_PARAM_ERROR(460, "请求参数错误");

    private int code;
    private String msg;

    CodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static CodeEnum codeOf(int code) {
        for (CodeEnum state : values()) {
            if (state.getCode() == code) {
                return state;
            }
        }
        return CodeEnum.CODE_UNKNOWN;
    }
}
