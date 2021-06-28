package com.sfh.feign;

import com.sfh.feign.error.ErrorFactory;
import com.sfh.feign.error.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "serve1", url = "127.0.0.1:9001",
//       configuration = FeignConfiguration.class ,
        fallbackFactory = ErrorFactory.class)
public interface Test1FeignApi {

    @PostMapping("test")
     String  get(@RequestBody long time) throws InterruptedException ;

}
