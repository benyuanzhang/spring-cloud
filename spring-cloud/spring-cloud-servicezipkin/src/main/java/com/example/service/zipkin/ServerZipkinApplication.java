package com.example.service.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

/**
 * service zipkin启动类
 *
 * @author benyuan.zhang
 * @date 2017/8/7 10:19
 */
@SpringBootApplication
@EnableZipkinServer
public class ServerZipkinApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerZipkinApplication.class, args);
    }
}
