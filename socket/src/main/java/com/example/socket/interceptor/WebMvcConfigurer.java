package com.example.socket.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * @author lijing
 * @date 2019/12/28 15:19
 */
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

    @Bean
    public WebMvcConfigurer getInterfaceAuthCheckInterceptor() {
        return new WebMvcConfigurer();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /** 指定拦截器类 */
        registry.addInterceptor(new BootInterceptor())
                /** 指定该类拦截的url */
                .addPathPatterns("/**")
                .excludePathPatterns("/swagger-resources/**",
                        "/webjars/**", "/v2/**", "/swagger-ui.html/**",
                        "/userInfo/sendPhone","/userInfo/login","/userPassword/resettingUserPassword","/userPassword/callBack",
                        "/test/get");
    }
}
