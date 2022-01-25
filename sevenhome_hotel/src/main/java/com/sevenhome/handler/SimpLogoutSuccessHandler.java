package com.sevenhome.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sevenhome.utils.ResponseResult;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 退出成功后的处理器
 */
public class SimpLogoutSuccessHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest request,
                                HttpServletResponse response,
                                Authentication authentication) throws IOException, ServletException {
        //设置响应数据的编码格式
        response.setContentType("application/json;charset=UTF-8");

        //将ResponseResult转为json
        ObjectMapper mapper=new ObjectMapper();
        String json= mapper.writeValueAsString(new ResponseResult<>(2004, "退出成功"));//JackSon中将对象序列化为json字符串的方法

        PrintWriter out= response.getWriter();
        out.write(json);
        out.close();
    }
}
