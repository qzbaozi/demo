package com.sfh.feign.error;

import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.nio.charset.Charset;

public class FeignConfiguration {

    @Bean
    public ErrorDecoder errorDecoder() {
        return new UserErrorDecoder();
    }

    /**
     * 自定义错误
     */
    public class UserErrorDecoder implements ErrorDecoder {
        @Override
        public Exception decode(String methodKey, Response response) {
            Exception exception = null;
            try {
                // 获取原始的返回内容
                String json = Util.toString(response.body().asReader(Charset.defaultCharset()));
                exception=               ResponseRunError.of(response.status(),json);
            } catch (IOException ex) {
                return ex;
            }
            return exception;
        }
    }
}
