package com.pro.test.core.common.exception;

import com.pro.test.core.common.global.ErrorConstants;

/**
 * 异常信息存储类
 * 
 * @author BrainstorM
 *
 */
public class WebHandleException extends BaseException {

    /** 序列化*/
    private static final long serialVersionUID = -2147666713632365082L;

    /**
     * 构造函数
     * 
     * @param code 异常码
     */
    public WebHandleException(String code) {
        exceptionCode = code;
        excetionMessage = "网站发生错误";
    }
    
    /**
     * 构造函数
     * 
     * @param code 异常码
     */
    public WebHandleException(Long code) {
        exceptionCode = code == null ? exceptionCode : code.toString();
        excetionMessage = "网站发生错误";
    }

    /**
     * 构造函数
     * 
     * @param code 异常码
     * @param message 异常描述
     */
    public WebHandleException(String code, String message) {
        exceptionCode = code;
        excetionMessage = message;
    }
    
    /**
     * 构造函数
     * 
     * @param code 异常码
     * @param message 异常描述
     */
    public WebHandleException(Long code, String message) {
        exceptionCode = code == null ? exceptionCode : code.toString();
        excetionMessage = message;
    }
    
    public static WebHandleException getRequestDataErrorException() {
        return new WebHandleException(ErrorConstants.ERROR_CODE_WRONG_DATA, ErrorConstants.ERROR_CODE_WRONG_DATA_DESC);
    }
    
    public static WebHandleException getNoDataFoundException() {
        return new WebHandleException(ErrorConstants.ERROR_CODE_NO_DATA, ErrorConstants.ERROR_CODE_NO_DATA_DESC);
    }
    
    public static WebHandleException getRequestRepeatException() {
        return new WebHandleException(ErrorConstants.ERROR_CODE_REQUEST_REPEAT, ErrorConstants.ERROR_CODE_REQUEST_REPEAT_DESC);
    }

}
