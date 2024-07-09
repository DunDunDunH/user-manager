package com.dun.interception;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class LoginConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册UserLoginInterception拦截器
        InterceptorRegistration registration = registry.addInterceptor(new UserLoginInterception());
        // 拦截所有路径
        registration.addPathPatterns("/**");
        // 添加不拦截路径
        registration.excludePathPatterns(
                "/user/loginPage",
                "/user/registerPage",
                "/user/login",
                "/user/save",
                "/static/*/*"
        );
    }
}
