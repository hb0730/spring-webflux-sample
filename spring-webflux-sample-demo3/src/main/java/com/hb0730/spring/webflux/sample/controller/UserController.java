package com.hb0730.spring.webflux.sample.controller;

import com.hb0730.spring.webflux.sample.commons.web.CommonResult;
import com.hb0730.spring.webflux.sample.model.UserVO;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bing_huang
 * @date 2020/06/03 10:19
 * @since V1.0
 */
@RestController
@RequestMapping("/users")
public class UserController {

    /**
     * 用户列表
     */
    @GetMapping("/list")
    public Flux<UserVO> list() {
        // 查询列表
        List<UserVO> result = new ArrayList<>();
        result.add(new UserVO().setId(1).setUsername("yudaoyuanma"));
        result.add(new UserVO().setId(2).setUsername("woshiyutou"));
        result.add(new UserVO().setId(3).setUsername("chifanshuijiao"));
        return Flux.fromIterable(result);
    }

    /**
     * 获得指定用户编号的用户
     */
    @GetMapping("/get/{id}")
    public Mono<UserVO> get(@PathVariable("id") Integer id) {
        // 查询用户
        UserVO user = new UserVO().setId(id).setUsername("username:" + id);
        return Mono.just(user);
    }

    /**
     * 获得指定用户编号的用户
     */
    @GetMapping("/get")
    public Mono<CommonResult<UserVO>> get2(@RequestParam("id") Integer id) {
        // 查询用户
        UserVO user = new UserVO().setId(id).setUsername("username:" + id);
        CommonResult<UserVO> result = CommonResult.success(user);
        return Mono.just(result);
    }

    /**
     * 获得指定用户编号的用户
     *
     * @param id 用户编号
     * @return 用户
     */
    @GetMapping("/get3")
    public UserVO get3(@RequestParam("id") Integer id) {
        return new UserVO().setId(id).setUsername("username:" + id);
    }

    /**
     * 获得指定用户编号的用户
     *
     * @param id 用户编号
     * @return 用户
     */
    @GetMapping("/get4")
    public CommonResult<UserVO> get4(@RequestParam("id") Integer id) {
        // 查询用户
        UserVO user = new UserVO().setId(id).setUsername("username:" + id);
        // 返回
        return CommonResult.success(user);
    }

}
