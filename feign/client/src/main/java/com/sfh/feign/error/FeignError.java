package com.sfh.feign.error;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

//@Configuration
@Slf4j
public class FeignError  implements ErrorDecoder {
        ObjectMapper objectMapper = new ObjectMapper();

        @Override
        public Exception decode(String s, Response response) {

            try {
            } catch (Exception var4) {
                log.error(var4.getMessage());
                return new InternalException(var4.getMessage());
            }
            return new InternalException("系统异常,请联系管理员");
        }



}
