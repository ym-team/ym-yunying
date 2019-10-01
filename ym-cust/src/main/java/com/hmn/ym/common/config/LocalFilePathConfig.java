package com.hmn.ym.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

@Configuration
public class LocalFilePathConfig {
    @Value("${file.local.path}")
    private String localFilePath;

    @Value("${file.local.prefix}")
    public String localFilePrefix;

    @Bean
    public WebMvcConfigurer webMvcConfigurerAdapter() {
        return new WebMvcConfigurer() {
            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                registry.addResourceHandler(localFilePrefix + "/**").addResourceLocations(ResourceUtils.FILE_URL_PREFIX + localFilePath + File.separator);
            }
        };
    }
}
