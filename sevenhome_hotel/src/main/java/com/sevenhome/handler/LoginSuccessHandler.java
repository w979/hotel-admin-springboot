package com.sevenhome.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sevenhome.redis.impl.RedisStrRepository;
import com.sevenhome.utils.JwtTokenUtils;
import com.sevenhome.utils.ResponseResult;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    //jackson对象
    private final ObjectMapper mapper=new ObjectMapper();

    @Resource
    private RedisStrRepository redisStrRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {
        //获得登录用户在security中的对象
        User user = (User) authentication.getPrincipal();
        //设置响应数据的编码格式
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        //将ResponseResult转为json
        PrintWriter out=httpServletResponse.getWriter();
        try {
            //调用生成token方法
            String token= JwtTokenUtils.createJwtToken(user.getUsername(),user.getAuthorities());
            //redis里存储token
            redisStrRepository.setJwtToken(user.getUsername(), token);
            //使用统一消息返回类封装数据
            out.write(mapper.writeValueAsString(new ResponseResult<Object>(200,"登录成功",token)));
        } catch (Exception e) {
            out.write(mapper.writeValueAsString(new ResponseResult<Object>(6001,"token异常")));
        }finally {
            out.flush();
            out.close();
        }
    }
}
