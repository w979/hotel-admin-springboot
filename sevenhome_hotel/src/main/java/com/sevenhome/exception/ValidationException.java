package com.sevenhome.exception;

import org.springframework.validation.BindingResult;

/**
 * 后端表单验证异常类
 */
public class ValidationException extends Exception{

    private BindingResult result;

    public BindingResult getResult() {
        return result;
    }

    public ValidationException(BindingResult result) {
        this.result = result;
    }
}
