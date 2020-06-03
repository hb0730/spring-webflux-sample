package com.hb0730.spring.webflux.sample.configuration;

import com.hb0730.spring.webflux.sample.handler.GlobalResponseBodyHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.reactive.accept.RequestedContentTypeResolver;

/**
 * @author bing_huang
 * @date 2020/06/03 10:10
 * @see org.springframework.web.reactive.config.WebFluxConfigurationSupport#responseBodyResultHandler
 * @since V1.0
 */
@Configuration
public class WebFluxConfiguration {

    @Bean
    public GlobalResponseBodyHandler responseWrapper(ServerCodecConfigurer serverCodecConfigurer,
                                                     RequestedContentTypeResolver requestedContentTypeResolver) {
        return new GlobalResponseBodyHandler(serverCodecConfigurer.getWriters(), requestedContentTypeResolver);
    }
}
