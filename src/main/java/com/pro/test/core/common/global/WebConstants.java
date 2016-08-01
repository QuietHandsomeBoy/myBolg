package com.pro.test.core.common.global;

/**
 * web常量
 * 
 * @author ycz
 *
 */
public class WebConstants {

	/** 请求方式get*/
    public final static String REQUEST_METHOD_GET = "GET";

    /** 请求方式post*/
    public final static String REQUEST_METHOD_POST = "POST";



    /** 参数名rid,主要存放主键值*/
    public final static String PARAM_NAME_RID = "rid";

    /** 参数名order,存放某个字段的排序方式,如:order = user_id desc*/
    public final static String PARAM_NAME_ORDER = "order";

    /** 日期间隔后缀begin*/
    public final static String PARAM_RANGE_DATE_SUFFIX_BEGIN = "Begin";

    /** 日期间隔后缀end*/
    public final static String PARAM_RANGE_DATE_SUFFIX_END = "End";

    /** 参数名autoToken，存入token值*/
    public final static String PARAM_NAME_TOKEN = "autoToken";

    /** 参数名autoLogging,是否自动保存日志*/
    public final static String PARAM_NAME_LOGGING = "autoLogging";



    /** 控制类型 1 增加*/
    public final static int CONTROLLER_TYPE_ADD = 1;

    /** 控制类型 2 修改*/
    public final static int CONTROLLER_TYPE_EDIT = 2;



    /** 控制类的几个基本方法,delete(删除)方法*/
    public final static String URI_NAME_DELETE = "delete";

    /** 控制类的几个基本方法,add(增加)方法*/
    public final static String URI_NAME_ADD = "add";

    /** 控制类的几个基本方法,edit(修改)方法*/
    public final static String URI_NAME_EDIT = "edit";

    /** 控制类的几个基本方法,detail(查看)方法*/
    public final static String URI_NAME_DETAIL = "detail";

    /** 控制类的几个基本方法,list(数据列表)方法*/
    public final static String URI_NAME_LIST = "list";



    /** SQL排序方式 asc 升序*/
    public final static String SQL_ORDER_ASC = "asc";

    /** SQL排序方式 desc 降序*/
    public final static String SQL_ORDER_DESC = "desc";



    /** 默认的超级权限标识*/
    public final static Long GLOBAL_DEFAULT_ROLE_ID_ADMIN = 0L;




    /** 属性requestPagination,用于存放分页器对象*/
    public final static String REQUEST_ATTR_NAME_PAGINATION = "requestPagination";

    /** 属性requestExceptionCode,用于存放异常编码*/
    public final static String REQUEST_ATTR_NAME_EXCEPTION_CODE = "requestExceptionCode";

    /** 属性requestExceptionCode,用于存放异常描述*/
    public final static String REQUEST_ATTR_NAME_EXCEPTION_DESC = "requestExceptionDesc";



    /** 属性sessionValidateStat,用于存放验证状态*/
    public final static String SESSION_ATTR_NAME_VALIDATE_STAT = "sessionValidateStat";

    /** 属性sessionValidateForward,用于存放验证转发*/
    public final static String SESSION_ATTR_NAME_VALIDATE_FORWARD = "sessionValidateForward";

    /** 属性sessionPrivList,用于存放权限列表*/
    public final static String SESSION_ATTR_NAME_PRIV_LIST = "sessionPrivList";

    /** 属性sessionPrivMap,用于存放权限容器*/
    public final static String SESSION_ATTR_NAME_PRIV_MAP = "sessionPrivMap";



    /** 存放具有application生命周期的会话容器*/
    public final static String APPLICATION_ATTR_NAME_SESSION_CONTAINER = "applicationSessionContainer";

    /** 存放具有application生命周期的线程安全队列*/
    public final static String APPLICATION_ATTR_NAME_LOGGING_VISIT = "applicationLoggingVisit";

    /** 存放具有application生命周期的线程安全队列*/
    public final static String APPLICATION_ATTR_NAME_LOGGING_OPER = "applicationLoggingOper";


}
