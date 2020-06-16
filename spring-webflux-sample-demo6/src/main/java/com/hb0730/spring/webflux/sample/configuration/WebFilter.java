package com.hb0730.spring.webflux.sample.configuration;

import org.junit.jupiter.api.Order;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.util.Collections;

/**
 * web filter 级别
 *
 * @author bing_huang
 * @date 2020/06/16 8:45
 * @see <a href="https://docs.spring.io/spring/docs/5.2.7.RELEASE/spring-framework-reference/web-reactive.html#webflux-cors-webfilter">webfilter</a>
 * @since V1.0
 */
public class WebFilter {
    @Bean
    @Order(0) // 设置 order 排序。这个顺序很重要哦，为避免麻烦请设置在最前
    public CorsWebFilter corsFilter() {
        // 创建 UrlBasedCorsConfigurationSource 配置源，类似 CorsRegistry 注册表
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        // 创建 CorsConfiguration 配置，相当于 CorsRegistration 注册信息
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(Collections.singletonList("*")); // 允许所有请求来源
        config.setAllowCredentials(true); // 允许发送 Cookie
        config.addAllowedMethod("*"); // 允许所有请求 Method
        config.setAllowedHeaders(Collections.singletonList("*")); // 允许所有请求 Header
        // config.setExposedHeaders(Collections.singletonList("*")); // 允许所有响应 Header
        config.setMaxAge(1800L); // 有效期 1800 秒，2 小时
        source.registerCorsConfiguration("/**", config);
        // 创建 CorsWebFilter 对象
        return new CorsWebFilter(source); // 创建 CorsFilter 过滤器
    }
}
