package com.example.redis.lock.work;

/**
 * 获取锁后需要处理的逻辑
 *
 * @author benyuan.zhang
 * @date 2017/8/7 14:50
 */
public interface AquiredLockWorker<T> {

    T invokeAfterLockAquire() throws Exception;
}
