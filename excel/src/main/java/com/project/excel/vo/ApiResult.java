package com.project.excel.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Restful API接口统一返回格式
 */
@Data
public class ApiResult<T> implements Serializable {

    private static final long serialVersionUID = -5852648804138941556L;

    /**
     * 结果码
     */
    private int code;

    /**
     * 结果码对应的描述信息
     */
    private String message;

    /**
     * 请求返回数据
     * 如果请求失败，则数据返回null
     */
    private T data;

    public ApiResult() {
        this.code = ResultCode.SUCCESS.getCode();
        this.message = ResultCode.SUCCESS.getMessage();
    }

    public ApiResult(String message) {
        this.code = ResultCode.SUCCESS.getCode();
        this.message = message;
    }

    public ApiResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ApiResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public void error(String message) {
        this.code = ResultCode.FAIL.getCode();
        this.message = message;
    }

    public void error(int code,String message) {
        this.code = code;
        this.message = message;
    }
}
