package com.pro.test.core.common.global;

/**
 * 常量类
 * 
 * @author ycz
 *
 */
public class ErrorConstants {

	/** 成功标识*/
    public static final Long ERROR_CODE_SUCC = 0L;
    /** 成功*/
    public static final String ERROR_CODE_SUCC_DESC = "成功";
    
    /** 失败标识*/
    public static final Long ERROR_CODE_FAIL = -1L;
    /** 失败*/
    public static final String ERROR_CODE_FAIL_DESC = "失败";

    /** 强制修改密码标识*/
    public static final Long ERROR_CODE_CHANGE_PASSWORD = 100L;
    /** 修改密码提示内容*/
    public static final String ERROR_CODE_CHANGE_PASSWORD_DESC = "请修改初始密码或者已过期密码";
    
    /** 账号或密码错误标识*/
    public static final Long ERROR_CODE_WRONG_LOGIN = 1000L;
    /** 账号或密码错误提示内容*/
    public static final String ERROR_CODE_WRONG_LOGIN_DESC = "错误的帐号或密码";
    
    /** 账号错误标识*/
    public static final Long ERROR_CODE_WRONG_USER = 1001L;
    /** 账号错误提示内容*/
    public static final String ERROR_CODE_WRONG_USER_DESC = "错误的帐号";
    
    /** 密码错误标识*/
    public static final Long ERROR_CODE_WRONG_PASSWORD = 1002L;
    /** 密码错误提示内容*/
    public static final String ERROR_CODE_WRONG_PASSWORD_DESC = "错误的密码";
    
    /** 未登录或session已失效标识*/
    public static final Long ERROR_CODE_NO_SESSION = 1003L;
    /**  未登录或session已失效提示内容*/
    public static final String ERROR_CODE_NO_SESSION_DESC = "没有登录或者登录超时";
    
    /** 无权限标识*/
    public static final Long ERROR_CODE_NO_PRIV = 1004L;
    /** 无权限提示内容*/
    public static final String ERROR_CODE_NO_PRIV_DESC = "抱歉，没有权限访问";

    /** 无数据标识*/
    public static final Long ERROR_CODE_NO_DATA = 1101L;
    /** 无数据提示内容*/
    public static final String ERROR_CODE_NO_DATA_DESC = "抱歉，没有相关数据";
    
    /** 无效数据标识*/
    public static final Long ERROR_CODE_UNVALID_DATA = 1102L;
    /** 无效数据提示内容*/
    public static final String ERROR_CODE_UNVALID_DATA_DESC = "无效数据";
    
    /** 请求数据标识*/
    public static final Long ERROR_CODE_WRONG_DATA = 1103L;
    /** 请求数据提示内容*/
    public static final String ERROR_CODE_WRONG_DATA_DESC = "错误的请求数据";
    
    /** 重复提交标识*/
    public static final Long ERROR_CODE_REQUEST_REPEAT = 1104L;
    /** 重复提交提示内容*/
    public static final String ERROR_CODE_REQUEST_REPEAT_DESC = "数据处理中，请不要重复提交";
    
}
