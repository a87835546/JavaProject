package com;

import com.yanchen.Check;
import org.junit.Test;

public class TestIndex {
    @Test
    public void show(){
        System.out.println("show");
    }
    @Check(name = "zhangsan")
    public void calculate(){
        System.out.printf("cal");
    }
}
