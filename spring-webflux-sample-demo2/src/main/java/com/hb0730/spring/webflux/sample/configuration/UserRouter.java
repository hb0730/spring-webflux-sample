package com.hb0730.spring.webflux.sample.configuration;

import com.hb0730.spring.webflux.sample.model.UserVO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author bing_huang
 * @date 2020/06/02 8:22
 * @since V1.0
 */
@Configuration
@EnableWebFlux
public class UserRouter {

    /**
     * 用户集合
     */
    @Bean
    public RouterFunction<ServerResponse> userList() {
        return userListRouter;
    }

    RouterFunction<ServerResponse> userListRouter = RouterFunctions.route(RequestPredicates.GET("/user/list"), new HandlerFunction<ServerResponse>() {
        @Override
        public Mono<ServerResponse> handle(ServerRequest request) {
            List<UserVO> users = new ArrayList<>();
            users.add(new UserVO().setId(1).setUsername("yudaoyuanma"));
            users.add(new UserVO().setId(2).setUsername("woshiyutou"));
            users.add(new UserVO().setId(3).setUsername("chifanshuijiao"));
            return ServerResponse.ok().bodyValue(users);
        }
    });

    /**
     * 获取指定用户
     */
    @Bean
    public RouterFunction<ServerResponse> getTest() {
        // https://docs.spring.io/spring/docs/current/spring-framework-reference/web-reactive.html#webflux-fn-predicates

//        return RouterFunctions.route().GET("/user", RequestPredicates.path("/{id}"), new HandlerFunction<ServerResponse>() {
//            @Override
//            public Mono<ServerResponse> handle(ServerRequest request) {
//                Integer id = Integer.valueOf(request.pathVariable("id"));
//                // 查询用户
//                UserVO user = new UserVO().setId(id).setUsername(UUID.randomUUID().toString());
//                // 返回列表
//                return ServerResponse.ok().bodyValue(user);
//            }
//        }).build();

        return RouterFunctions.route().GET("/user/{id}", new HandlerFunction<ServerResponse>() {
            @Override
            public Mono<ServerResponse> handle(ServerRequest request) {
                Integer id = Integer.valueOf(request.pathVariable("id"));
                // 查询用户
                UserVO user = new UserVO().setId(id).setUsername(UUID.randomUUID().toString());
                // 返回列表
                return ServerResponse.ok().bodyValue(user);
            }
        }).build();
    }

}
