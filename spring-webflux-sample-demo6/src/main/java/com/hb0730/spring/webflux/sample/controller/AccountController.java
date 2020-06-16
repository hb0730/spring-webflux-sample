package com.hb0730.spring.webflux.sample.controller;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

/**
 * 1.@CrossOrigin 方法上
 *
 * @author bing_huang
 * @date 2020/06/16 8:35
 * @see <a href="https://docs.spring.io/spring/docs/5.2.7.RELEASE/spring-framework-reference/web-reactive.html#webflux-cors">@CrossOrigin</a>
 * @since V1.0
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @CrossOrigin
    @GetMapping("/{id}")
    public Mono<String> retrieve(@PathVariable Long id) {
        return Mono.just(id.toString());
    }

    @DeleteMapping("/{id}")
    public Mono<Void> remove(@PathVariable Long id) {

        return null;
    }

}
