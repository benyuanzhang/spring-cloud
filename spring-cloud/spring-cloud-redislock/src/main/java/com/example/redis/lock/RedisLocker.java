package com.example.redis.lock;

import com.example.redis.lock.config.RedissonConnector;
import com.example.redis.lock.exception.UnableToAquireLockException;
import com.example.redis.lock.work.AquiredLockWorker;
import com.example.redis.lock.work.DistributedLocker;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * redis具体锁实现
 *
 * @author benyuan.zhang
 * @date 2017/8/7 15:03
 */
@Component
public class RedisLocker implements DistributedLocker {

    private final static String LOCKER_PREFIX = "lock:";

    @Autowired
    RedissonConnector redissonConnector;

    @Override
    public <T> T lock(String resourceName, AquiredLockWorker<T> worker) throws UnableToAquireLockException, Exception {
        return lock(resourceName, worker, 100);
    }

    @Override
    public <T> T lock(String resourceName, AquiredLockWorker<T> worker, int lockTime) throws UnableToAquireLockException, Exception {
        RedissonClient redisson= redissonConnector.getClient();
        RLock lock = redisson.getLock(LOCKER_PREFIX + resourceName);
        // Wait for 100 seconds seconds and automatically unlock it after lockTime seconds
        boolean success = lock.tryLock(100, lockTime, TimeUnit.SECONDS);
        if (success) {
            try {
                return worker.invokeAfterLockAquire();
            } finally {
                lock.unlock();
            }
        }
        throw new UnableToAquireLockException();
    }
}
