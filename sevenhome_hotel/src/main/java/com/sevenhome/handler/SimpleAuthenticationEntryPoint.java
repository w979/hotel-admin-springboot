package com.sevenhome.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sevenhome.utils.ResponseResult;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SimpleAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest,
                         HttpServletResponse httpServletResponse,
                         AuthenticationException e) throws IOException, ServletException {
        //设置响应数据的编码格式
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        //将ResponseResult转为json
        ObjectMapper objectMapper = new ObjectMapper();
        String json= objectMapper.writeValueAsString(new ResponseResult<>(4003, "账号未登录"));
        PrintWriter out =httpServletResponse.getWriter();
        out.write(json);
        out.flush();
        out.close();
    }
}
