package com.ncamc.boot3.redis;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;


import java.util.UUID;

@SpringBootTest
public class Boot3RedisApplication {

    @Autowired
    StringRedisTemplate redisTemplate;
    @Test
    void contextLoads(){
        redisTemplate.opsForValue().set("string", UUID.randomUUID().toString());
        String string = redisTemplate.opsForValue().get("string");
        System.out.println(string);
    }

    @Test
    void testList(){
        String listName = "listname";
        redisTemplate.opsForList().leftPush(listName,"1");
        redisTemplate.opsForList().leftPush(listName,"2");
        redisTemplate.opsForList().leftPush(listName,"3");
        String pop = redisTemplate.opsForList().leftPop(listName);
        Assertions.assertEquals(pop,"3");
    }

    @Test
    void testSet(){
        String setName = "setname";
        redisTemplate.opsForSet().add(setName,"1","2","3");
        Boolean member = redisTemplate.opsForSet().isMember(setName, "2");

        Assertions.assertTrue(member);
        Boolean aBoolean = redisTemplate.opsForSet().isMember(setName, "5");
        Assertions.assertTrue(aBoolean);
    }

    @Test
    void testhash(){
        String mapName = "mapname";
        redisTemplate.opsForHash().put(mapName,"name","张三");
        redisTemplate.opsForHash().put(mapName,"age","18");

        Object name = redisTemplate.opsForHash().get(mapName, "name");
        System.out.println(name);
    }
}
