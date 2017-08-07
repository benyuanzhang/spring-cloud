package com.example.redis.lock.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 获取RedissonClient连接类
 *
 * @author benyuan.zhang
 * @date 2017/8/7 15:02
 */
@Component
public class RedissonConnector {

    RedissonClient redisson;

    @PostConstruct
    public void init() {
        Config config = new Config();
        config.useClusterServers().addNodeAddress("10.16.30.161:6381", "10.16.30.161:6382", "10.16.30.161:6383");
        redisson = Redisson.create(config);
    }

    public RedissonClient getClient() {
        return redisson;
    }
}
