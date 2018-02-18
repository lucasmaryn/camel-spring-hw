package com.javainuse;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("appContext-camel.xml");
        ctx.start();

        System.out.println("App context started.");
        try {
            Thread.sleep(5 * 100 * 60);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ctx.stop();
        ctx.close();
    }
}
