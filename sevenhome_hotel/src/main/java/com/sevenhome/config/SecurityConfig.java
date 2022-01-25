package com.sevenhome.config;

import com.sevenhome.filter.JwtFilter;
import com.sevenhome.handler.*;
import com.sevenhome.service.impl.LoginDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.annotation.Resource;

@EnableWebSecurity  //打开security配置
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private LoginDetailService loginDetailService;

    @Resource
    private LoginSuccessHandler loginSuccessHandler;

    @Resource
    private JwtFilter jwtFilter;

    /*跨域原*/
    private CorsConfigurationSource CorsConfigurationSource() {
        CorsConfigurationSource source =   new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");    //同源配置，*表示任何请求都视为同源，若需指定ip和端口可以改为如“localhost：8080”，多个以“，”分隔；
        corsConfiguration.addAllowedHeader("*");//header，允许哪些header，本案中使用的是token，此处可将*替换为token；
        corsConfiguration.addAllowedMethod("*");    //允许的请求方法，PSOT、GET等
        ((UrlBasedCorsConfigurationSource) source).registerCorsConfiguration("/**",corsConfiguration); //配置允许跨域访问的url
        return source;
    }


    /**
     * 构造注入
     * @param loginDetailService
     */
    public SecurityConfig(@Lazy LoginDetailService loginDetailService){
        this.loginDetailService=loginDetailService;
    }

    /**
     * 将PasswordEncoder注入到ioc容器
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    /**
     * 处理security的认证
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //调用UserDetailService中的认证结果并赋值给AuthenticationManagerBuilder，做认证和鉴权对比
        auth.userDetailsService(loginDetailService).passwordEncoder(passwordEncoder());
    }

    /**
     * 修改Spring Security默认的过滤器链【重要】
     * 修改security默认的行为
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /* super.configure(http);*/
        http.authorizeRequests()
                .anyRequest().authenticated(); // 除了上面的权限以外的，都必须登录才能访问   // 1 表示sceurity要对那些请求进行拦截,对所有请求都拦截
        //登录相关配置
        /**
         * 登录默认配置
         *  1.security内置登录页面
         *  2.登录请求默认为login
         *  3.登录表单的账号:username 密码:password
         *  spring security 的登录请求只能是post请求
         */
        http.formLogin()

                /*.loginPage("/Login.html")//告诉security你的登录页面是那个
                .loginProcessingUrl("/dologin") //告诉security我自己的登录页面是那个*/
                /*.usernameParameter("account")//使用默认的就不用写这两句
                .passwordParameter("password")*/
                .successHandler(loginSuccessHandler)
                .failureHandler(new LoginFailureHandler())
                .permitAll();//对所有登录相关请求放行(不拦截)

        //退出成功后的处理器
        http.logout().logoutSuccessHandler(new SimpLogoutSuccessHandler());

         //使用表单作为登录界面
        http.exceptionHandling()
                .authenticationEntryPoint(new SimpleAuthenticationEntryPoint())
                .accessDeniedHandler(new SimpleAccessDeniedHandler());

        http.csrf().disable();  // 3  不管

        //前后端项目中要禁用掉session
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        //将自定义的jwtFilter添加到Spring Security过滤器链的倒数第二个以前
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        http.cors().configurationSource(CorsConfigurationSource());//允许跨域访问
    }
}
