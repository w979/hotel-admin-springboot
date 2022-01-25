package com.sevenhome.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sevenhome.utils.ResponseResult;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        AuthenticationException e) throws IOException, ServletException {
        //设置响应数据的编码格式
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        //将ResponseResult转为json
        ObjectMapper objectMapper = new ObjectMapper();
        String json="";
//        if (e instanceof )
        //JackSon中将对象序列化为json字符串的方法
        System.out.println(e);
        if(e instanceof LockedException){
            json= objectMapper.writeValueAsString(new ResponseResult<>(4006, "用户帐户被锁定"));
        }else if(e instanceof CredentialsExpiredException){
            json= objectMapper.writeValueAsString(new ResponseResult<>(4005, "用户凭据已过期"));
        }else if(e instanceof AccountExpiredException){
            json= objectMapper.writeValueAsString(new ResponseResult<>(4004, "用户帐户已过期"));
        }else if(e instanceof DisabledException){
            json= objectMapper.writeValueAsString(new ResponseResult<>(4003, "用户被禁用"));
        }else if(e instanceof BadCredentialsException){
            json= objectMapper.writeValueAsString(new ResponseResult<>(4002, "密码错误"));
        }else if(e instanceof InternalAuthenticationServiceException){
            json= objectMapper.writeValueAsString(new ResponseResult<>(4001, "帐号不存在"));
        }
        PrintWriter out =httpServletResponse.getWriter();
        out.write(json);
        out.flush();
        out.close();
    }
}
