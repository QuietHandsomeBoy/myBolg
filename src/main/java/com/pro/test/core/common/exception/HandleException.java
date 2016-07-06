package com.pro.test.core.common.exception;

/**
 * Created by hxpeng on 2016/6/29.
 */
public class HandleException extends BaseException {
    private static final long serialVersionUID = -2824353315225211749L;

    public HandleException() {
    }

    public HandleException(String code, String message) {
        this.exceptionCode = code;
        this.excetionMessage = message;
    }

    public HandleException(Throwable throwable) {
        this.excetionMessage = throwable.getMessage();
    }
}
