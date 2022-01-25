package com.sevenhome.filter;

import com.sevenhome.redis.impl.RedisStrRepository;
import com.sevenhome.service.impl.LoginDetailService;
import com.sevenhome.utils.JwtTokenUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class JwtFilter extends OncePerRequestFilter {

    @Resource
    private LoginDetailService loginDetailService;

    @Resource
    private RedisStrRepository redisRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        // 1、如果Spring Security中已经有有一个Authentication Token,那么这个请求就不归JwtFilter管，直接放行
        //获得Spring Security上下文中的Authentication对象
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        //如果Spring Security中没有Authentication Token,这个请求就需要被JwtFilter管理，
        if (authentication != null) {
            //Security Context 中已有 Authentication Token
            filterChain.doFilter(request, response);
            return;
        }

        //2、请求中没有token信息，不用向Spring Security的上下文中保存Authentication Token
        //获得请求中的token信息,jwtToken为请求头中携带的token名称
        String jwtStr = request.getHeader("jwtToken");
        if (StringUtils.isEmpty(jwtStr)) {
            //请求中没有token
            filterChain.doFilter(request, response);
            return;
        }

        //3、请求中有token信息，但是token非法，不用向Spring Security的上下文中保存Authentication Token
        if (!JwtTokenUtils.verify(jwtStr)) {
            //有token，但非法
            filterChain.doFilter(request, response);
            return;
        }
        //获得token中的username
        String username = JwtTokenUtils.getUserNameFormJwt(jwtStr);
        //4.请求中有token信息，且token合法,但token已过期

        try {
            if (!redisRepository.getJwtToken(username)){
                filterChain.doFilter(request, response);
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //5、请求中有token信息，且token合法,就从请求中获取携带的token，
        // 然后转为Spring Security的Authentication Token(需要带有用户所有的权限),保存在Spring Security上下文中


        //获取redis中权限
        String authority =null;
        try {
            authority = redisRepository.getAuthority(username);
        } catch (Exception e) {
            e.printStackTrace();
        }

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, username, AuthorityUtils.commaSeparatedStringToAuthorityList(authority));
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request, response);//放行到下一个过滤器
    }
}
