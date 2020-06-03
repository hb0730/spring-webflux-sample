package com.hb0730.spring.webflux.sample.controller;

import com.hb0730.spring.webflux.sample.commons.web.CommonResult;
import com.hb0730.spring.webflux.sample.model.UserVO;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebFlux;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureWebFlux
@AutoConfigureWebTestClient
class UserControllerTest {
    @Autowired
    WebTestClient webTestClient;

    @Test
    void list() {
        CommonResult result = webTestClient.get().uri("/users/list")
                .exchange()
                .expectStatus().isOk()
                .expectBody(CommonResult.class).returnResult().getResponseBody();
        System.out.println(result.getData());
    }

    @Test
    void get() {
        CommonResult result = webTestClient.get().uri("/users/get/1")
                .exchange()
                .expectStatus().isOk()
                .expectBody(CommonResult.class)
                .returnResult()
                .getResponseBody();
        System.out.println(result.getData());
    }

    @Test
    void get2() {
        CommonResult result = webTestClient.get().uri("/users/get?id=2")
                .exchange()
                .expectStatus().isOk()
                .expectBody(CommonResult.class)
                .returnResult()
                .getResponseBody();
        System.out.println(result.getData());
    }

    @Test
    void get3() {
        CommonResult result = webTestClient.get().uri("/users/get3?id=3")
                .exchange()
                .expectStatus().isOk()
                .expectBody(CommonResult.class)
                .returnResult()
                .getResponseBody();
        System.out.println(result.getData());
    }

    @Test
    void get4() {
        CommonResult result = webTestClient.get().uri("/users/get4?id=4")
                .exchange()
                .expectStatus().isOk()
                .expectBody(CommonResult.class)
                .returnResult()
                .getResponseBody();
        System.out.println(result.getData());
    }
}
