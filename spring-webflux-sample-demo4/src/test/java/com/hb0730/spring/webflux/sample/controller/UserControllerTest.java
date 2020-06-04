package com.hb0730.spring.webflux.sample.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebFlux;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureWebFlux
@AutoConfigureWebTestClient
class UserControllerTest {
    @Autowired
    WebTestClient client;

    @Test
    void exception01() {
        String result = client.get().uri("/user/exception-01")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .returnResult().getResponseBody();
        System.out.println(result);
    }

    @Test
    void exception02() {
        String result = client.get().uri("/user/exception-02")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .returnResult().getResponseBody();
        System.out.println(result);
    }
}
