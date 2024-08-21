package com.vish.spring.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Component
public class LoginInterceptConfig implements WebMvcConfigurer {

  @Autowired
  HandlerInterceptor handlerInterceptor;

  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(handlerInterceptor);
  }

}
