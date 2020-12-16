package com;


import com.yanchen.aop.MyAspect;
import com.yanchen.aop.MyTarget;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TextSpring {

    @Test
    public void test(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        MyTarget target = app.getBean(MyTarget.class);
        target.show();

        MyAspect aspect = app.getBean(MyAspect.class);
        aspect.test();
    }
}
