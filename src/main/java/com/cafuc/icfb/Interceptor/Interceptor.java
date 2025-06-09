package com.cafuc.icfb.Interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Interceptor implements WebMvcConfigurer {

    @Bean
    LoginInterceptor loginInterceptor() {
        return new LoginInterceptor();
    }
    @Bean
    IpInterceptor ipInterceptor() {
        return new IpInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加一个拦截器，排除登录url
        registry.addInterceptor(loginInterceptor())
                .addPathPatterns("/**").excludePathPatterns("/index","/login","/static/**","/loginfunc","/loginerror");
        registry.addInterceptor(ipInterceptor()).addPathPatterns("/**");
    }
}
