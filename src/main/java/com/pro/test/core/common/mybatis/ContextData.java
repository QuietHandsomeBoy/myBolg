package com.pro.test.core.common.mybatis;

import com.alibaba.druid.util.StringUtils;
import com.pro.test.core.common.exception.WebHandleException;
import com.pro.test.core.common.global.ErrorConstants;
import com.pro.test.core.common.global.WebConstants;
import com.pro.test.core.common.mybatis.entity.Pagination;

import java.util.HashMap;

/**
 * Created by hxpeng on 2016/6/29.
 */
/**
 * 上下文数据实体类(主要保存查询条件)
 *
 * @author ycz
 *
 */
public class ContextData extends HashMap<String, Object> {

    /** 序列*/
    private static final long serialVersionUID = -481338054940734302L;

    /** 分页器*/
    private Pagination pagination;

    /**
     * 无参构造方法
     */
    public ContextData() {

    }

    /**
     * 有参构造方法
     *
     * @param pagination 分页器
     */
    public ContextData(Pagination pagination) {
        this.pagination = pagination;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    /**
     * 设置实体对象
     *
     * @param entity 实体对象
     */
    public void setEntity(Object entity) {
        setEntity(MappingConvertor.toFormName(entity.getClass().getSimpleName()), entity);
    }

    /**
     * 设置实体对象
     * @param entityName 实体对象名称
     * @param entity 实体对象
     */
    public void setEntity(String entityName, Object entity) {
        put(entityName, entity);
    }

    /**
     * 设置时间段
     *
     * @param dataName 数据名称
     * @param beginDate 开始时间
     * @param endDate 结束时间
     */
    public void setTimeSlot(String dataName, String beginDate, String endDate) {
        this.put(dataName + WebConstants.PARAM_RANGE_DATE_SUFFIX_BEGIN, beginDate);
        this.put(dataName + WebConstants.PARAM_RANGE_DATE_SUFFIX_END, endDate);
    }

    /**
     * 获取排序方式
     *
     * @return 返回排序方式
     */
    public String getOrder() {
        return (String)this.get(WebConstants.PARAM_NAME_ORDER);
    }

    /**
     * 设置排序方式
     *
     * @param orderStr 排序字符串
     *
     * @throws Exception 统一异常处理
     */
    public void setOrder(String orderStr) throws Exception {
        if (StringUtils.isEmpty(orderStr)) {
            return;
        }

        String[] chars = {"|", "&", ";", "；", "$", "%", "@", "\'", "\"", "<>", "()", "+", "0x0d", "0x0a", /*",", */"，", "\\"};

        if (contains(orderStr, chars)) {
            throw new WebHandleException(ErrorConstants.ERROR_CODE_WRONG_DATA,
                    "输入错误: " + orderStr);
        }

        String[] orderGroupArray = orderStr.replaceAll("\\s{1,}", " ").split(",");
        String result = "";

        for (int i = 0; i < orderGroupArray.length; i++) {
            String[] orderArray = orderGroupArray[i].split(" ");

            String orderItem = orderArray[0];
            String sortItem = WebConstants.SQL_ORDER_ASC;

            if (1 < orderArray.length) {
                sortItem = orderArray[1].toLowerCase();
            }

            if (!(WebConstants.SQL_ORDER_ASC.equals(sortItem) || WebConstants.SQL_ORDER_DESC.equals(sortItem))) {
                return;
            }

            result += result.length() > 0 ? "," : "";
            result += " " + MappingConvertor.toColumnName(orderItem) + " " + sortItem;
        }

        this.put(WebConstants.PARAM_NAME_ORDER, result);
    }

    @Override
    public Object put(String key, Object value) {
        return super.put(key, value);
    }

    /**
     * 字符串(str)中是否包含某个(chars)字符串
     * @param str 字符串
     * @param chars 字符串组
     *
     * @return 返回包含结果
     */
    private boolean contains(String str, String[] chars) {
        boolean flag = false;

        if (StringUtils.isEmpty(str) || chars == null || chars.length <= 0) {
            return flag;
        }

        for (String c : chars) {
            if (str.contains(c)) {
                flag = true;
                break;
            }
        }

        return flag;
    }

}