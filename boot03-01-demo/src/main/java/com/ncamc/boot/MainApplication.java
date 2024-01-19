package com.ncamc.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        //java10提供的局部变量类型自动推断
        var ioc= SpringApplication.run(MainApplication.class,args);
        for (String name : ioc.getBeanDefinitionNames()) {
            System.out.println(name);
        }
    }
}
