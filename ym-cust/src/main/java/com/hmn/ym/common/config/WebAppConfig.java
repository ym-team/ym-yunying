package com.hmn.ym.common.config;

import com.google.common.collect.Lists;
import com.hmn.ym.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.util.List;

@Configuration
public class WebAppConfig implements WebMvcConfigurer {
    @Resource
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> patterns = Lists.newArrayList();
        patterns.add("/static/**");
        patterns.add("/css/*");
        patterns.add("/images/*");
        patterns.add("/js/*");
        patterns.add("/captcha.do");
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns(patterns);
    }
}
