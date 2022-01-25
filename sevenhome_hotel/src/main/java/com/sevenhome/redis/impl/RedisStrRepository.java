package com.sevenhome.redis.impl;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * redis 字符类型存储
 */
@Component
public class RedisStrRepository {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 存储jwtToken到redis
     * @param username
     * @param jwtToken
     * @throws Exception
     */
    public void setJwtToken(String username , String jwtToken)throws Exception{
        try {
            stringRedisTemplate.opsForValue().set(username, jwtToken, 30, TimeUnit.MINUTES);
            System.out.println("==>token存储redis成功");
        }catch (Exception e){
            System.out.println("==>token存储redis失败");
        }
    }

    /**
     *存储登录用户的权限
     * @param username
     * @param authority
     * @throws Exception
     */
    public void setAuthority(String username, String authority)throws  Exception{
        try {
            stringRedisTemplate.opsForValue().set(username+"Authority", authority);
            System.out.println("==>用户权限存储redis成功");
        }catch (Exception e){
            System.out.println("==>用户权限存储redis失败");
        }

    }

    /**
     * 获取当前登录用户的权限
     * @param username
     * @throws Exception
     */
    public String getAuthority(String username)throws  Exception{
        String authority = stringRedisTemplate.opsForValue().get(username + "Authority");
        return authority;
    }

    public boolean getJwtToken(String username)throws Exception{
        return stringRedisTemplate.hasKey(username);

        //获取jwtToken 的过期时间
        //Long aLong = stringRedisTemplate.opsForValue().getOperations().getExpire(username);
    }
}
