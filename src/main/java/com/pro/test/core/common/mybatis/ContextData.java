package com.pro.test.core.common.mybatis;

import com.alibaba.druid.util.StringUtils;
import com.pro.test.core.common.mybatis.entity.Pagination;

import java.util.HashMap;

/**
 * Created by hxpeng on 2016/6/29.
 */
public class ContextData extends HashMap<String, Object>{

    private static final long serialVersionUID = -481338054940734302L;
    private Pagination pagination;

    public ContextData() {}

    public ContextData(Pagination pagination)
    {
        this.pagination = pagination;
    }

    public Pagination getPagination()
    {
        return this.pagination;
    }

    public void setPagination(Pagination pagination)
    {
        this.pagination = pagination;
    }

    public void setEntity(Object entity)
    {
        setEntity(MappingConvertor.toFormName(entity.getClass().getSimpleName()), entity);
    }

    public void setEntity(String entityName, Object entity)
    {
        put(entityName, entity);
    }

    public void setTimeSlot(String dataName, String beginDate, String endDate)
    {
        put(dataName + "Begin", beginDate);
        put(dataName + "End", endDate);
    }

    public String getOrder()
    {
        return (String)get("order");
    }

    public Object put(String key, Object value)
    {
        return super.put(key, value);
    }

    private boolean contains(String str, String[] chars)
    {
        boolean flag = false;
        if ((StringUtils.isEmpty(str)) || (chars == null) || (chars.length <= 0)) {
            return flag;
        }
        String[] arrayOfString;
        int j = (arrayOfString = chars).length;
        for (int i = 0; i < j; i++)
        {
            String c = arrayOfString[i];
            if (str.contains(c))
            {
                flag = true;
                break;
            }
        }
        return flag;
    }
}
