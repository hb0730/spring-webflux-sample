package com.hb0730.spring.webflux.sample.controller;

import com.hb0730.spring.webflux.sample.constants.ServiceExceptionEnum;
import com.hb0730.spring.webflux.sample.exception.ServiceException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author bing_huang
 * @date 2020/06/04 7:42
 * @since V1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {
    /**
     * 测试抛出 NullPointerException 异常
     */
    @GetMapping("/exception-01")
    public Mono<Void> exception01() {
        throw new NullPointerException("没有粗面鱼丸");
    }

    /**
     * 测试抛出 ServiceException 异常
     */
    @GetMapping("/exception-02")
    public Mono<Void> exception02() {
        throw new ServiceException(ServiceExceptionEnum.USER_NOT_FOUND);
    }
}
