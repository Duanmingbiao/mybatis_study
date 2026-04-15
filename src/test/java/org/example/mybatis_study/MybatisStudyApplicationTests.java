package org.example.mybatis_study;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;

@SpringBootTest
class MybatisStudyApplicationTests {

    @Test
    void contextLoads() {

    }
//    @Test
//    public void testjwt(){
//        HashMap<String, Object> claims = new HashMap<>();
//        claims.put("userId", 1);
//        claims.put("username", "admin");
//        String secret = "testtesttesttesttesttesttesttest";
//        String token = Jwts.builder() //创建一个 JWT 构建器（Builder）对象
//                .claims(claims)   //设置 Payload（载荷数据）
//                .issuedAt(new Date()) //设置 签发时间（iat）
//                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) //设置 过期时间（exp）
//                .signWith(Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8))) //设置 签名算法 + 密钥
//                .compact(); //真正生成 JWT 字符串
//        System.out.println("生成的token" + token);
//    }

}
