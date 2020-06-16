package com.hb0730.spring.webflux.sample.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;

/**
 * 全局
 *
 * @author bing_huang
 * @date 2020/06/16 8:43
 * @see <a href="https://docs.spring.io/spring/docs/5.2.7.RELEASE/spring-framework-reference/web-reactive.html#webflux-cors-global">全局配置</a>
 * @since V1.0
 */
@EnableWebFlux
@Configuration
public class WebConfig implements WebFluxConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/api/**")
                .allowedOrigins("https://domain2.com")
                .allowedMethods("PUT", "DELETE")
                .allowedHeaders("header1", "header2", "header3")
                .exposedHeaders("header1", "header2")
                .allowCredentials(true).maxAge(3600);

        // Add more mappings...
    }
}
