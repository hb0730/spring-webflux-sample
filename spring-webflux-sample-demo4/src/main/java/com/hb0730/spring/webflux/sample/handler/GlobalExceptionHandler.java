package com.hb0730.spring.webflux.sample.handler;

import com.hb0730.spring.webflux.sample.constants.ServiceExceptionEnum;
import com.hb0730.spring.webflux.sample.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ServerWebInputException;
import reactor.core.publisher.Mono;

/**
 * 全局异常处理<br>
 * 本实例做简单的返回，
 * 一般应该做统一返回
 *
 * @author bing_huang
 * @date 2020/06/04 7:34
 * @see <a href="https://docs.spring.io/spring/docs/5.2.6.RELEASE/spring-framework-reference/web-reactive.html#webflux-dispatcher-exceptions">例外情况</a>
 * @see <a href="https://docs.spring.io/spring/docs/5.2.6.RELEASE/spring-framework-reference/web-reactive.html#webflux-ann-controller-exceptions">异常管理</a>
 * @since V1.0
 */
@ControllerAdvice(basePackages = "com.hb0730.spring.webflux.sample.controller")
public class GlobalExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理 ServiceException 异常
     */
    @ResponseBody
    @ExceptionHandler(value = ServiceException.class)
    public Mono<String> serviceExceptionHandler(ServiceException e) {
        LOGGER.debug("[serviceExceptionHandler]", e);
        return Mono.just(e.getMessage());
    }

    /**
     * 处理 ServerWebInputException 异常
     * <p>
     * WebFlux 参数不正确
     */
    @ResponseBody
    @ExceptionHandler(value = ServerWebInputException.class)
    public Mono<String> serverWebInputExceptionHandler(ServerWebInputException e) {
        LOGGER.debug("[ServerWebInputExceptionHandler]", e);
        return Mono.just(ServiceExceptionEnum.MISSING_REQUEST_PARAM_ERROR.getMessage());
    }

    /**
     * 处理其它 Exception 异常
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Mono<String> exceptionHandler(Exception e) {
        // 记录异常日志
        LOGGER.error("[exceptionHandler]", e);
        // 返回 ERROR CommonResult
        return Mono.just(ServiceExceptionEnum.SYS_ERROR.getMessage());
    }
}
