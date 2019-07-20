package com.binary.servermonitor.config;

import com.binary.servermonitor.componet.LoginHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 * @author Wei Peng
 */
@SuppressWarnings("ALL")
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("/index.html");
        registry.addViewController("/login").setViewName("/login.html");
    }
    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        WebMvcConfigurer configurer = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("/login.html");
//                registry.addViewController("/register.html").setViewName("register.html");
//                registry.addViewController("/index").setViewName("login");
//                registry.addViewController("/index.html").setViewName("login");
//                registry.addViewController("/main").setViewName("index.html");
            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/login","/login.html","/user/register","/register.html","/user/login","/asserts/css/**.css","/asserts/js/**.js","/asserts/img/**","/asserts/i/**","/asserts/**"
                                ,"/asserts/fonts/**","/asserts/**","/assets/**","/webshell","/email","http://111.116.20.126/ws/","/ws/");

            }

        };
        return configurer;
    }
}
