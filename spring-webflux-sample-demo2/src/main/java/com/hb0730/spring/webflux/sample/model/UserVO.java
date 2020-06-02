package com.hb0730.spring.webflux.sample.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * 用户 VO
 *
 * @author bing_huang
 * @date 2020/06/02 8:20
 * @since V1.0
 */
@NoArgsConstructor
@AllArgsConstructor
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
