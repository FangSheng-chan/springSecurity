package com.ss.springsecuritydemo1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fangsheng
 * @date 2021/8/3 4:01 下午
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("hello")
    public String hell0(){
        return "hello security";
    }

}
