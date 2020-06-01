package com.hb0730.spring.webflux.demo1.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebFlux;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

/**
 * @see  <a href="https://docs.spring.io/spring/docs/5.2.6.RELEASE/spring-framework-reference/testing.html#webtestclient">webtestclient</a>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureWebFlux
@AutoConfigureWebTestClient
class TestControllerTest {
    @Autowired
    private WebTestClient webClient;

    @Test
    void helloWebFlux() {
        String result = webClient.get().uri("/test")
                // 执行请求
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).returnResult().getResponseBody();
        System.out.println(result);
    }

    @Test
    void hellWebFlux() {
        Boolean body = webClient.get().uri("/test/{type}", 1)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Boolean.class).isEqualTo(true).returnResult().getResponseBody();
        System.out.println(body);
        body = webClient.get().uri("/test/{type}", 2)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Boolean.class).consumeWith(e -> e.equals(true)).returnResult().getResponseBody();
        System.out.println(body);
    }

    @Test
    void list() {
        List<String> result = webClient.post().uri("/test/list")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(String.class).returnResult().getResponseBody();
        System.out.println(result);
    }
}
