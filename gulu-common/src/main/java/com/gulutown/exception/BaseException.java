package com.gulutown.exception;

/**
 * 业务异常
 */
public class BaseException extends RuntimeException {
    public BaseException(String message) {
        super(message);
    }
}
