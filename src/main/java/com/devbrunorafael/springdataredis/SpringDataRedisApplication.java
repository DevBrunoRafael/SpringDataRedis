package com.devbrunorafael.springdataredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
@EnableRedisRepositories
public class SpringDataRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataRedisApplication.class, args);
    }

}
