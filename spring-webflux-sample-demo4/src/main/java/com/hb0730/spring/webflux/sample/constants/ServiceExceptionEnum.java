package com.hb0730.spring.webflux.sample.constants;

import lombok.Getter;
import lombok.Setter;

/**
 * @author bing_huang
 * @date 2020/06/04 7:30
 * @since V1.0
 */
public enum ServiceExceptionEnum {
    SUCCESS(0, "成功"),

    SYS_ERROR(2001001000, "服务端发生异常"),

    MISSING_REQUEST_PARAM_ERROR(2001001001, "参数缺失"),

    USER_NOT_FOUND(1001002000, "用户不存在");
    @Getter
    @Setter
    private Integer code;
    @Getter
    @Setter
    private String message;

    ServiceExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
