package com.cafuc.icfb.Interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;


public class IpInterceptor implements HandlerInterceptor {
    @Autowired
    private static final Logger logger = LoggerFactory.getLogger(IpInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        logger.info("在访问");
        return true;
    }
}