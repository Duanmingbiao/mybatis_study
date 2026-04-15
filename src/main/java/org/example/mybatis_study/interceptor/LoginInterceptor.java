package org.example.mybatis_study.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.mybatis_study.utils.JwtUtil;
import org.example.mybatis_study.utils.Result;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("Interceptor 拦截成功");

        // 1. 获取 token
        String token = request.getHeader("token");

        // 2. 判断 token 是否存在
        if (!StringUtils.hasLength(token)) {
            writeJson(response, Result.error("未登录或登录状态已过期"));
            return false; // 🔥 拦截
        }

        // 3. 校验 token
        if (!JwtUtil.validateToken(token)) {
            writeJson(response, Result.error("token无效"));
            return false;
        }

        // 4. 放行
        return true;
    }

    private void writeJson(HttpServletResponse response, Object obj) throws Exception {
        response.setContentType("application/json;charset=UTF-8");
        new ObjectMapper().writeValue(response.getWriter(), obj);
    }
}