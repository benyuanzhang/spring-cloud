package com.example.redis.lock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * redlock启动类
 *
 * @author benyuan.zhang
 * @date 2017/8/7 15:54
 */
@SpringBootApplication
public class RedlockApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedlockApplication.class, args);
    }
}
