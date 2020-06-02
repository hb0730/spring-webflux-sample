package com.hb0730.spring.webflux.sample.configuration;

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
class UserRouterTest {
    @Autowired
    WebTestClient client;

    @Test
    void userList() {
//        client.get().uri("/user/list")
//                .exchange()
//                .expectStatus().isOk()
//                .expectBody().json("[\n" +
//                "    {\n" +
//                "        \"id\": 1,\n" +
//                "        \"username\": \"yudaoyuanma\"\n" +
//                "    },\n" +
//                "    {\n" +
//                "        \"id\": 2,\n" +
//                "        \"username\": \"woshiyutou\"\n" +
//                "    },\n" +
//                "    {\n" +
//                "        \"id\": 3,\n" +
//                "        \"username\": \"chifanshuijiao\"\n" +
//                "    }\n" +
//                "]");

//        client.get().uri("/user/list")
//                .exchange()
//                .expectStatus().isOk()
//                .expectBody().json("[\n" +
//                "    {\n" +
//                "        \"id\": 1,\n" +
//                "        \"username\": \"yudaoyuanma\"\n" +
//                "    },\n" +
//                "    {\n" +
//                "        \"id\": 2,\n" +
//                "        \"username\": \"woshiyutou\"\n" +
//                "    },\n" +
//                "]");

        List<UserVO> result = client.get().uri("/user/list")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(UserVO.class)
                .returnResult().getResponseBody();
        System.out.println(result);


//        List<UserVO> result = client.get().uri("/user/list")
//                .exchange()
//                .expectStatus().isOk()
//                .expectBodyList(UserVO.class)
//                .hasSize(2).returnResult().getResponseBody();
//        System.out.println(result);


    }

    @Test
    void getTest() {
        UserVO user = client.get().uri("/user/1")
                .exchange()
                .expectStatus().isOk()
                .expectBody(UserVO.class).returnResult().getResponseBody();
        System.out.println(user);


    }
}
