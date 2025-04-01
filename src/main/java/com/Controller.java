package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cache")
public class Controller {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping("/test")
    public String testRedis() {
//        System.out.println("innn");
        redisTemplate.opsForValue().set("message", "Hello from Spring + Valkey!");
        String value = redisTemplate.opsForValue().get("message");
        return "Cache test: " + value;
    }
    @GetMapping("/ping")
    public String testApi() {
        return "Cache test";
    }
    @PostMapping("/set")
    public String cacheSet(@RequestBody CacheRequest cacheRequest) {
        redisTemplate.opsForValue().set(cacheRequest.getKey(), cacheRequest.getValue());
        return "Cache set successfully";
    }
    @GetMapping("/get")
    public String cacheGet(@RequestParam String key) {
        return redisTemplate.opsForValue().get(key);
    }
}
