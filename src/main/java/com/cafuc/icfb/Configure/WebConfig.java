package com.cafuc.icfb.Configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 映射物理路径到虚拟URL路径
        registry.addResourceHandler("/images/**")
                .addResourceLocations("file:D:/collectimg/");
    }
}