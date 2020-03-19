package com.example.cartcare.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class UsingStaticController extends WebMvcConfigurationSupport {

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");

        registry.addResourceHandler("/Home/upimg/**").addResourceLocations("classpath:/upimg/");
        registry.addResourceHandler("/Home/images/**").addResourceLocations("classpath:/static/images/");
        //映射头像保存地址
        registry.addResourceHandler("/uploadCartCare/**").addResourceLocations("file:E:/uploadCartCare/");
    }
}