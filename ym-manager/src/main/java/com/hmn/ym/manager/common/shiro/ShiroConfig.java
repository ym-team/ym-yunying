package com.hmn.ym.manager.common.shiro;

import com.google.common.collect.Maps;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.Map;

@Configuration
public class ShiroConfig {
    private static final String CIPHER_KEY = "U0VFX1JFQ19LRVlfV09SRA==";

    @Bean
    public ShiroDbRealm shiroDbRealm() {
        return new ShiroDbRealm();
    }

    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilter() {
        ShiroFilterFactoryBean filterBean = new ShiroFilterFactoryBean();
        // 设置SecurityManager
        filterBean.setSecurityManager(this.securityManager());
        // 登录链接
        filterBean.setLoginUrl("/login");
        // 登录成功后要跳转的链接
        filterBean.setSuccessUrl("/");

        // authc:都必须认证通过才可以访问; anon：可以匿名访问-->
        Map<String, String> filterChain = Maps.newLinkedHashMap();
        filterChain.put("/static/**", "anon");
        filterChain.put("/css/**", "anon");
        filterChain.put("/images/**", "anon");
        filterChain.put("/js/**", "anon");
        filterChain.put("/metronic/**", "anon");
        filterChain.put("/plugins/**", "anon");
        filterChain.put("/favicon.ico", "anon");
        filterChain.put("/login", "anon");
        filterChain.put("/logout", "logout");
        filterChain.put("/**", "user");

        filterBean.setFilterChainDefinitionMap(filterChain);

        return filterBean;
    }

    @Bean(name = "securityManager")
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 设置realm.
        securityManager.setRealm(this.shiroDbRealm());
        // 注入缓存管理器
        securityManager.setCacheManager(this.cacheManager());
        // session管理器
        securityManager.setSessionManager(this.sessionManager());
        //注入记住我管理器
        securityManager.setRememberMeManager(this.rememberMeManager());

        return securityManager;
    }

    @Bean
    public DefaultWebSessionManager sessionManager() {
        DefaultWebSessionManager manager = new DefaultWebSessionManager();
        // 设置SessionDao
        manager.setSessionDAO(this.redisSessionDao());
        // 删除过期的session
        manager.setDeleteInvalidSessions(true);
        // 是否定时检查session
        manager.setSessionValidationSchedulerEnabled(true);
        // 设置系统的sessionId
        manager.setSessionIdCookie(this.sessionCookie());
        manager.setSessionIdCookieEnabled(true);

        return manager;
    }

    @Bean
    public EnterpriseCacheSessionDAO redisSessionDao() {
        return new EnterpriseCacheSessionDAO();
    }

    @Bean
    public CookieRememberMeManager rememberMeManager() {
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(this.rememberMeCookie());
        cookieRememberMeManager.setCipherKey(Base64.decode(CIPHER_KEY));
        return cookieRememberMeManager;
    }

    @Bean
    public SimpleCookie sessionCookie() {
        SimpleCookie simpleCookie = new SimpleCookie("COOKIE");
        simpleCookie.setHttpOnly(true);
        simpleCookie.setMaxAge(-1);
        return simpleCookie;
    }

    @Bean
    public SimpleCookie rememberMeCookie() {
        SimpleCookie simpleCookie = new SimpleCookie("COOKIE_RE");
        simpleCookie.setMaxAge(259200);
        simpleCookie.setHttpOnly(true);
        return simpleCookie;
    }

    @Bean("memoryCacheManager")
    protected CacheManager cacheManager() {
        return new MemoryConstrainedCacheManager();
    }

    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
        creator.setProxyTargetClass(true);
        return creator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor() {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(this.securityManager());
        return advisor;
    }

    @Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }
}
