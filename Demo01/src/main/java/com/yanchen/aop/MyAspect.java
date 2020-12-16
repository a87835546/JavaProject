package com.yanchen.aop;

import org.springframework.stereotype.Component;

@Component("myAspect")
public class MyAspect {
    public void test(){
        System.out.println("my aspect .....");
    }
}
