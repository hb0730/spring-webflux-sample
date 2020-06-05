package com.hb0730.spring.webflux.sample.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;

/**
 * @author bing_huang
 * @date 2020/06/05 8:48
 * @see <a href="https://docs.spring.io/spring/docs/5.3.0-SNAPSHOT/spring-framework-reference/web-reactive.html#webflux-filters">过滤器</a>
 * @since V1.0
 */
@Configuration
@Order(-1)
public class DemoWebFilter implements WebFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(DemoWebFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {

        return chain.filter(exchange).doOnSuccess(new Consumer<Void>() {
            @Override
            public void accept(Void aVoid) {
                LOGGER.info("---------[accept][执行成功]-----------");
            }
        });
    }
}
