package com.hb0730.spring.webflux.sample.router;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;

/**
 * @author bing_huang
 * @date 2020/06/05 8:51
 * @since V1.0
 */
@Configuration
@EnableWebFlux
public class UserRouter {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserRouter.class);

    @Bean
    public RouterFunction<ServerResponse> routerFunction() {
        return router.filter(new HandlerFilterFunction<ServerResponse, ServerResponse>() {
            @Override
            public Mono<ServerResponse> filter(ServerRequest request, HandlerFunction<ServerResponse> next) {
                return next.handle(request).doOnSuccess(new Consumer<ServerResponse>() {
                    @Override
                    public void accept(ServerResponse serverResponse) {
                        LOGGER.info("[accept][执行成功]");
                    }
                });
            }
        });
    }

    RouterFunction<ServerResponse> router = RouterFunctions.route(RequestPredicates.GET("/users2/demo2")
            , new HandlerFunction<ServerResponse>() {
                @Override
                public Mono<ServerResponse> handle(ServerRequest request) {
                    return ServerResponse.ok().bodyValue("demo");
                }
            });
}
