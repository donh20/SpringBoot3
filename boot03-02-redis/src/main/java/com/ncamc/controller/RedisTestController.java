package com.ncamc.controller;

import com.ncamc.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisTestController {

    @Autowired
    StringRedisTemplate StringRedisTemplate;

    @Autowired
    RedisTemplate redisTemplate;

    @GetMapping("/count")
    public String count() {
        Long hello = StringRedisTemplate.opsForValue().increment("hello");


        return "访问了["+hello+"]次";
    }

    @GetMapping("/person/save")
    public String savePerson(){
        Person person = new Person(1L, "张三", "12345@qq.com", 19, "intern");
        redisTemplate.opsForValue().set("person",person);
        return "OK";
    }
    @GetMapping("/person/get")
    public Person getPerson(){

        Person person = (Person) redisTemplate.opsForValue().get("person");
        return person;
    }

}
