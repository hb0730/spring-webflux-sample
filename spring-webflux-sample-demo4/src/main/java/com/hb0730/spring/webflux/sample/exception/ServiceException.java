package com.hb0730.spring.webflux.sample.exception;

import com.hb0730.spring.webflux.sample.constants.ServiceExceptionEnum;
import lombok.Getter;

/**
 * @author bing_huang
 * @date 2020/06/04 7:32
 * @since V1.0
 */
public class ServiceException extends RuntimeException {

    @Getter
    private final Integer code;

    public ServiceException(ServiceExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMessage());
        this.code = exceptionEnum.getCode();
    }
}
