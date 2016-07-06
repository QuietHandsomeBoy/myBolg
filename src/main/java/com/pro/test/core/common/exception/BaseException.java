package com.pro.test.core.common.exception;

/**
 * Created by hxpeng on 2016/6/29.
 */
public class BaseException extends Exception {

    protected static final long serialVersionUID = -5035523579171879123L;
    public static final String UNKNOWN_EXCEPTION_CODE = "-1";
    public static final String UNKNOWN_EXCEPTION_MESSAGE = "系统内部错误！";
    protected String exceptionCode = "-1";
    protected String excetionMessage = "系统内部错误！";

    public BaseException() {
    }

    public BaseException(String code, String message) {
        this.exceptionCode = code;
        this.excetionMessage = message;
    }

    public BaseException(Throwable throwable) {
        this.excetionMessage = throwable.getMessage();
    }

    public void setCode(String code) {
        this.exceptionCode = code;
    }

    public String getCode() {
        return this.exceptionCode;
    }

    public void setMessage(String message) {
        this.excetionMessage = message;
    }

    public String getMessage() {
        return this.excetionMessage;
    }
}
