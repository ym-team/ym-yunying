package com.hmn.ym.manager.common.config;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebSiteMeshFilter extends ConfigurableSiteMeshFilter {

    @Override
    protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
        builder.addDecoratorPath("/*", "/WEB-INF/views/layouts/default.jsp")
                .addDecoratorPath("/user/*", "/WEB-INF/views/layouts/default.jsp")
                .addExcludedPath("/static/**")
                .addExcludedPath("/js/*")
                .addExcludedPath("/metronic/*")
                .addExcludedPath("/plugins/*")
                .addExcludedPath("/login");
    }
}
