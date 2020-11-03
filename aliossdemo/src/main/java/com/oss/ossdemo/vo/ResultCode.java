package com.oss.ossdemo.vo;

/**
 * API接口返回状态码
 */
public enum  ResultCode {

    FAIL(0,"失败"),
    SUCCESS(1,"成功"),
    AUTHORIZATION_INVALID(1001,"Missing or invalid Authorization header"),
    TOKEN_EXPIRED(1002,"token expired"),
    TOKEN_REFRESHED(1003,"token refreshed"),
    TOKEN_INVALID(1004,"token invalid"),
    OTHER_EXCEPTION(1005,"other exception");

    /**
     * 状态码
     */
    private int code;

    /**
     * 状态描述
     */
    private String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
