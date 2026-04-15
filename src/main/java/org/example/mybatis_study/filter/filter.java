package org.example.mybatis_study.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.mybatis_study.utils.JwtUtil;
import org.example.mybatis_study.utils.Result;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebFilter("/*") //表示拦截所有接口，注意在spring项目中使用过滤器filter需要在启动项中配置注解
public class filter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter拦截成功");
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        //获取请求地址判断是否是/login
        String requestURI = httpRequest.getRequestURL().toString();
        if (requestURI.contains("/login")) {//登录接口直接放行
            filterChain.doFilter(httpRequest, httpResponse);
            return;
        }
        String token = httpRequest.getHeader("token");
        if (!StringUtils.hasLength(token)) {
            Result<Object> error = Result.error("未登录或登录状态已过期");
            System.out.println(error);
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(error);
            httpResponse.setContentType("application/json;charset=UTF-8");
            httpResponse.getWriter().write(json);
            return;
        }

        boolean valid = JwtUtil.validateToken(token);
        if (!valid) {
            Result<Object> error = Result.error("token无效");
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(error);
            httpResponse.setContentType("application/json;charset=UTF-8");
            httpResponse.getWriter().write(json);
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);//放行逻辑
    }

}
