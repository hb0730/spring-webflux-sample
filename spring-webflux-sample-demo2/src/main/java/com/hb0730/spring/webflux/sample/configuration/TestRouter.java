package com.hb0730.spring.webflux.sample.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * @author bing_huang
 * @date 2020/06/02 8:00
 * @since V1.0
 */
@Configuration
public class TestRouter {

    /**
     * @see <a href="https://docs.spring.io/spring/docs/current/spring-framework-reference/web-reactive.html#webflux-fn-predicates">谓词</a>
     * @see <a href="https://docs.spring.io/spring/docs/current/spring-framework-reference/web-reactive.html#webflux-fn-running">运行服务器</a>
     */
    @Bean
    public RouterFunction<ServerResponse> test() {
        return router;
    }


    RouterFunction<ServerResponse> router = RouterFunctions.route().GET("/test", request ->
            ServerResponse.ok().bodyValue("Hello Function WebFlux")).build();
}

