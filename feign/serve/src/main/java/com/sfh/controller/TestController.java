package com.sfh.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @RequestMapping("test")
    public String  get(@RequestBody Long time) throws InterruptedException {
        System.out.println(time);
        Thread.sleep(time);

        return "succeed";
    }

}
