package com.example.redis.lock.exception;

/**
 * 不能获取锁的异常类
 *
 * @author benyuan.zhang
 * @date 2017/8/7 15:00
 */
public class UnableToAquireLockException extends RuntimeException{

    public UnableToAquireLockException() {
    }

    public UnableToAquireLockException(String message) {
        super(message);
    }

    public UnableToAquireLockException(String message, Throwable cause) {
        super(message, cause);
    }
}
