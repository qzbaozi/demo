package com.sfh.controller;

import com.sfh.feign.Test1FeignApi;
import com.sfh.feign.TestFeignApi;
import com.sfh.feign.error.ResponseRunError;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;


@RestController
public class TestController {

    @Autowired
    TestFeignApi testFeignApi;
    @Autowired
    Test1FeignApi test1FeignApi;

    @GetMapping("test")
    public String  get(long time, int type, HttpServletResponse response) throws InterruptedException {
        long now = System.currentTimeMillis();
        System.err.println(time+"  "+type);
        try {
            String s = null;
            switch (type){
                case 0:
                 s = testFeignApi.get(time);
break;
                default:
s=                    test1FeignApi.get(time);
            }
            System.err.println(s);
            return s;
        }catch  (Exception e){
             e.printStackTrace();
        }finally {
now=            System.currentTimeMillis()-now;
            System.err.println(now);
        }
return "error";
    }

}
