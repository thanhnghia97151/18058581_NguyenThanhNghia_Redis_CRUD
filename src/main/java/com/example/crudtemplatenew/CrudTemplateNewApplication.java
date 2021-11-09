package com.example.crudtemplatenew;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
public class CrudTemplateNewApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudTemplateNewApplication.class, args);
    }

    @Bean
    public LettuceConnectionFactory getLettuceConnectionFactory(){
        return new LettuceConnectionFactory();
    }
    @Bean
    public RedisTemplate getRedisTemplate(){
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(getLettuceConnectionFactory());
        return redisTemplate;
    }
}
