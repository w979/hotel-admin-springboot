package com.sevenhome.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sevenhome.utils.ResponseResult;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SimpleAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest,
                       HttpServletResponse httpServletResponse,
                       AccessDeniedException e) throws IOException, ServletException {

        //设置响应数据的编码格式
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        //将ResponseResult转为json
        ObjectMapper objectMapper = new ObjectMapper();
        String json= objectMapper.writeValueAsString(new ResponseResult<>(403, "无此权限，请联系管理员。。。"));
        PrintWriter out =httpServletResponse.getWriter();
        out.write(json);
        out.flush();
        out.close();
    }
}
