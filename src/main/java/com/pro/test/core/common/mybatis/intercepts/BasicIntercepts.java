package com.pro.test.core.common.mybatis.intercepts;

import com.pro.test.core.common.annotation.*;
import com.pro.test.core.util.UUIDUtils;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.springframework.core.annotation.AnnotationUtils;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Properties;

/**
 * Created by hxpeng on 2016/7/19.
 */
@Intercepts({@Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}) })
public class BasicIntercepts implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
        SqlCommandType sqlCommandType = mappedStatement.getSqlCommandType();
        Object parameter = invocation.getArgs()[1];
        Field[] fields = parameter.getClass().getDeclaredFields();

        Timestamp currentDate = new Timestamp(new Date().getTime());
        if(SqlCommandType.UPDATE==sqlCommandType) {
            for (Field field : fields) {
                if (AnnotationUtils.getAnnotation(field, LastUpdateBy.class) != null) {
                    field.setAccessible(true);
                    field.set(parameter,"admin");
                    field.setAccessible(false);
                }
                if (AnnotationUtils.getAnnotation(field, LastUpdateDate.class) != null) {
                    field.setAccessible(true);
                    field.set(parameter,currentDate);
                    field.setAccessible(false);
                }
            }
        } else if(SqlCommandType.INSERT==sqlCommandType){
            for (Field field : fields) {
                if (AnnotationUtils.getAnnotation(field, TableId.class) != null) {
                    field.setAccessible(true);
                    field.set(parameter, UUIDUtils.getUUID());
                }
                if (AnnotationUtils.getAnnotation(field, CreateBy.class) != null) {
                    field.setAccessible(true);
                    field.set(parameter,"admin");
                    field.setAccessible(false);
                }
                if (AnnotationUtils.getAnnotation(field, CreateDate.class) != null) {
                    field.setAccessible(true);
                    field.set(parameter,currentDate);
                    field.setAccessible(false);
                }
                if (AnnotationUtils.getAnnotation(field, LastUpdateBy.class) != null) {
                    field.setAccessible(true);
                    field.set(parameter,"admin");
                    field.setAccessible(false);
                }
                if (AnnotationUtils.getAnnotation(field, LastUpdateDate.class) != null) {
                    field.setAccessible(true);
                    field.set(parameter,currentDate);
                    field.setAccessible(false);
                }
            }
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object o) {
        if (o instanceof Executor) {
            return Plugin.wrap(o, this);
        } else {
            return o;
        }
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
