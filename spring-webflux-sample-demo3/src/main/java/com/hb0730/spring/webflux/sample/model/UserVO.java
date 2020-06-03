package com.hb0730.spring.webflux.sample.model;

import lombok.ToString;

import java.io.Serializable;

/**
 * @author bing_huang
 * @date 2020/06/03 10:01
 * @since V1.0
 */
@ToString
public class UserVO implements Serializable {
    /**
     * 编号
     */
    private Integer id;
    /**
     * 账号
     */
    private String username;

    public Integer getId() {
        return id;
    }

    public UserVO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserVO setUsername(String username) {
        this.username = username;
        return this;
    }
}
