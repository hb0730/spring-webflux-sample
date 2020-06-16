package com.hb0730.spring.webflux.sample.controller;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

/**
 * 2. @CrossOrigin 类上
 * @author bing_huang
 * @date 2020/06/16 8:42
 * @since V1.0
 */
@CrossOrigin(origins = "https://domain2.com", maxAge = 3600)
@RestController
@RequestMapping("/account2")
public class AccountController2 {

    @GetMapping("/{id}")
    public Mono<String> retrieve(@PathVariable Long id) {
        return Mono.just(id.toString());
    }

    @DeleteMapping("/{id}")
    public Mono<Void> remove(@PathVariable Long id) {

        return null;
    }
}
