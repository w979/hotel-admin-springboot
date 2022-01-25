package com.sevenhome.utils;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import lombok.SneakyThrows;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class JwtTokenUtils {
    //使用uuid生成密钥
    private static final String secret= UUID.randomUUID().toString();
    //用户数据的key
    private static final String usernameKey="usernameKey";
    //权限数据的key
    private static final String authoritiesKey="authorityKey";


    public static String createJwtToken(String username, Collection<? extends GrantedAuthority> authorityes) throws Exception {
        //创建头部对象
        JWSHeader jwsHeader =
                new JWSHeader.Builder(JWSAlgorithm.HS256)       // 加密算法
                        .type(JOSEObjectType.JWT) // 静态常量
                        .build();
        System.out.println(jwsHeader);

        Map<String,Object> map =new HashMap<>();
        map.put(usernameKey, username);
        map.put(authoritiesKey,authorityes);

        //创建载荷
        Payload payload= new Payload(map);

        //创建签名器
        JWSSigner jwsSigner = new MACSigner(secret);//密钥
        //创建签名
        JWSObject jwsObject = new JWSObject(jwsHeader, payload);// 头部+载荷
        jwsObject.sign(jwsSigner);//再+签名部分

        //生成token字符串
        return jwsObject.serialize();
    }
    /**
     * 验证jwt token是否合法
     * @param jwtStr
     * @return
     */
    @SneakyThrows
    public static boolean verify(String jwtStr) {
        JWSObject jwsObject=JWSObject.parse(jwtStr);
        JWSVerifier jwsVerifier=new MACVerifier(secret);
        return jwsObject.verify(jwsVerifier);
    }

    /**
     * 从token中解析出用户名
     * @param jwtStr
     * @return
     */
    @SneakyThrows
    public static String getUserNameFormJwt(String jwtStr){
        JWSObject jwsObject=JWSObject.parse(jwtStr);
        Map<String,Object> map=jwsObject.getPayload().toJSONObject();
        return (String) map.get(usernameKey);
    }
}
