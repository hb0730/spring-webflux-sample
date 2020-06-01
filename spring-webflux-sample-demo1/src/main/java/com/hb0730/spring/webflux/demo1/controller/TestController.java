package com.hb0730.spring.webflux.demo1.controller;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bing_huang
 * @date 2020/06/01 9:32
 * @since V1.0
 */
@RestController
@RequestMapping("/test")
public class TestController {

    /**
     * Mono 与Flux
     *
     * @see <a href="https://www.pianshen.com/article/868527566/">关于Mono和Flux的理解</a>
     */
    @GetMapping
    public Mono<String> helloWebFlux() {
        return Mono.just("hell webFlux");
    }

    @GetMapping("{type}")
    public Mono<Boolean> hellWebFlux(@PathVariable Integer type) {
        return Mono.just(type == 1);
    }

    @PostMapping("/list")
    public Flux<List<Integer>> list() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        return Flux.just(list);
    }
}
