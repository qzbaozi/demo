package com.sfh.feign;

import com.sfh.feign.error.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "serve",url = "127.0.0.1:9001",configuration = FeignConfiguration.class)
public interface TestFeignApi {

    @PostMapping("test")
     String  get(@RequestBody long time) throws InterruptedException ;

}
