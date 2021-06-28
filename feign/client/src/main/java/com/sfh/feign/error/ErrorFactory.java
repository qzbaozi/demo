package com.sfh.feign.error;

import com.sfh.feign.Test1FeignApi;
import feign.FeignException;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;

@Component
public class ErrorFactory implements FallbackFactory<Test1FeignApi> {
    @Override
    public Test1FeignApi create(Throwable throwable) {

        String s = null;
        FeignException e = null;
        if (throwable instanceof FeignException){
             e= (FeignException) throwable;
            int status = e.status();
            HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
response.setStatus(status);
            s = e.contentUTF8();
        }

        String finalS = s;
        return new Test1FeignApi() {
            @Override
            public String get(long time) throws InterruptedException {
                return finalS;
            }
        };
    }

    private void decode(Throwable throwable) {
    }
}
