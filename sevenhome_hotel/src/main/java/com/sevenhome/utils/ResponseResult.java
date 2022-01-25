package com.sevenhome.utils;

import lombok.Data;

/**
 * 统一消息返回类
 *
 * @param <T>
 */
@Data
public class ResponseResult<T> {
    private int code; // 状态码 200,成功，500:失败，403：无权
    private String msg; // 消息
    private T data; // 数据

    public ResponseResult() {
    }

    public ResponseResult(T data, int code) {
        this(code, "OK");
        this.data = data;
    }

    public ResponseResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static final ResponseResult<Void> SUCCESS = new ResponseResult<>(200, "OK");
    public static final ResponseResult<Void> NOTLOGINED = new ResponseResult<>(401, "未登录");
    public static final ResponseResult<Void> FORBIDDEN = new ResponseResult<>(403, "无权限");
    public static final ResponseResult<Void> Unauthenticated = new ResponseResult<>(402, "认证失败");
    public static final ResponseResult<Void> FAIL = new ResponseResult<>(500, "操作失败");
    public static final ResponseResult<Void> CUOWU = new ResponseResult<>(5001, "除数不能为0");
}

