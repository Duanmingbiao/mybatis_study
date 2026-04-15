package org.example.mybatis_study.utils;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.Map;

public class JwtUtil {
    private static final String SECRET = "creatjwtcreatjwtcreatjwtcreatjwt123456";

    private static final Key KEY = Keys.hmacShaKeyFor(
            SECRET.getBytes(StandardCharsets.UTF_8)
    );

    /**
     * 生成 token
     */
    public static String createToken(Map<String, Object> claims) {
        return Jwts.builder()
                .claims(claims)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1小时
                .signWith(KEY)
                .compact();
    }

    /**
     * 解析 token（核心方法）
     */
    public static Claims parseToken(String token) {
        return Jwts.parser()
                .verifyWith((javax.crypto.SecretKey) KEY)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    /**
     * 校验 token 是否有效
     */
    public static boolean validateToken(String token) {
        try {
            parseToken(token);
            return true;
        } catch (ExpiredJwtException e) {
            System.out.println("token已过期");
        } catch (UnsupportedJwtException e) {
            System.out.println("不支持的token");
        } catch (MalformedJwtException e) {
            System.out.println("token格式错误");
        } catch (SecurityException e) {
            System.out.println("签名错误");
        } catch (Exception e) {
            System.out.println("token解析失败");
        }
        return false;
    }

    /**
     * 从 token 获取某个值
     */
    public static Object getClaim(String token, String key) {
        Claims claims = parseToken(token);
        return claims.get(key);
    }

    /**
     * 判断是否过期
     */
    public static boolean isExpired(String token) {
        Date expiration = parseToken(token).getExpiration();
        return expiration.before(new Date());
    }
}