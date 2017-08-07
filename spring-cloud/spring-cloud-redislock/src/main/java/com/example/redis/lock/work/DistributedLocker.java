package com.example.redis.lock.work;

import com.example.redis.lock.exception.UnableToAquireLockException;

/**
 * 获取锁管理类
 *
 * @author benyuan.zhang
 * @date 2017/8/7 14:51
 */
public interface DistributedLocker {
    /**
     * 获取锁
     * @param resourceName  锁的名称
     * @param worker 获取锁后的处理类
     * @param <T>
     * @return 处理完具体的业务逻辑要返回的数据
     * @throws UnableToAquireLockException
     * @throws Exception
     */
    <T> T lock(String resourceName, AquiredLockWorker<T> worker) throws UnableToAquireLockException, Exception;

    <T> T lock(String resourceName, AquiredLockWorker<T> worker, int lockTime) throws UnableToAquireLockException, Exception;
}
