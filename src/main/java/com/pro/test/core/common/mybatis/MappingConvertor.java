package com.pro.test.core.common.mybatis;

import com.alibaba.druid.util.StringUtils;
import com.pro.test.core.common.annotation.Column;
import com.pro.test.core.common.annotation.Id;
import com.pro.test.core.common.annotation.Sequence;
import com.pro.test.core.common.exception.HandleException;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

/**
 * Created by hxpeng on 2016/6/29.
 */
public class MappingConvertor {
    public static String tableSeparator = "_";
    public static String columnSeparator = "_";

    public static String getSequenceName(Class<?> entityClass, String fieldName)
            throws NoSuchFieldException, SecurityException
    {
        return ((Sequence)entityClass.getDeclaredField(fieldName).getAnnotation(Sequence.class)).value();
    }

    public static String toEntityName(String tableName)
    {
        if (StringUtils.isEmpty(tableName)) {
            return tableName;
        }
        String[] strArray = tableName.split(tableSeparator);
        String res = "";
        for (int i = 0; i < strArray.length; i++) {
            res = res + strArray[i].substring(0, 1).toUpperCase() + strArray[i].substring(1).toLowerCase();
        }
        return res;
    }

    public static String toTableName(String entityName)
    {
        if (StringUtils.isEmpty(entityName)) {
            return entityName;
        }
        String res = "";
        int count = 0;

        int i = 0;
        for (int len = entityName.length(); i < len; i++)
        {
            char ch = entityName.charAt(i);
            if (Character.isUpperCase(ch))
            {
                if (count > 0) {
                    res = res + tableSeparator;
                }
                count++;
            }
            res = res + ch;
        }
        return res.toUpperCase();
    }

    public static String toVariableName(String columnName)
    {
        if (StringUtils.isEmpty(columnName)) {
            return columnName;
        }
        String[] strArray = columnName.split(columnSeparator);
        String res = "";
        for (int i = 0; i < strArray.length; i++) {
            if (i == 0) {
                res = res + strArray[i].toLowerCase();
            } else {
                res = res + strArray[i].substring(0, 1).toUpperCase() + strArray[i].substring(1).toLowerCase();
            }
        }
        return res;
    }

    public static String toColumnName(String variableName)
    {
        if (StringUtils.isEmpty(variableName)) {
            return variableName;
        }
        String res = "";

        int i = 0;
        for (int len = variableName.length(); i < len; i++)
        {
            char ch = variableName.charAt(i);

            res = res + (Character.isUpperCase(ch) ? tableSeparator + ch : Character.valueOf(ch));
        }
        return res.toUpperCase();
    }

    public static String toGetMethodName(String variableName)
    {
        return "get" + Character.toUpperCase(variableName.charAt(0)) + variableName.substring(1);
    }

    public static String toSetMethodName(String variableName)
    {
        return "set" + Character.toUpperCase(variableName.charAt(0)) + variableName.substring(1);
    }

    public static Object getVariableValue(Object obj, String variableName)
            throws Exception
    {
        Class<?> entityClass = obj.getClass();

        String methodName = toGetMethodName(variableName);
        Method method = entityClass.getMethod(methodName, new Class[0]);

        return method.invoke(obj, new Object[0]);
    }

    public static boolean isColumn(Field field)
    {
        Column column = (Column)field.getAnnotation(Column.class);
        if ((Modifier.isFinal(field.getModifiers())) || (Modifier.isStatic(field.getModifiers()))) {
            return false;
        }
        if ((column != null) && ("none".equalsIgnoreCase(column.value()))) {
            return false;
        }
        return true;
    }

    public static String toSelectItem(Class<?> entityClass)
    {
        Field[] fieldArray = entityClass.getDeclaredFields();

        String selectItem = "";
        int count = 0;
        for (int i = 0; i < fieldArray.length; i++) {
            if (isColumn(fieldArray[i]))
            {
                String variableName = toColumnName(fieldArray[i].getName());
                if (count > 0) {
                    selectItem = selectItem + ", ";
                }
                selectItem = selectItem + variableName;

                count++;
            }
        }
        return selectItem;
    }

    public static String toInsertItem(Object obj, List<Object> params)
            throws Exception
    {
        if ((obj == null) || (params == null)) {
            throw new Exception();
        }
        Field[] fieldArray = obj.getClass().getDeclaredFields();

        String tmpSqlItem = "";
        String tmpSqlValue = "";
        String variableName = "";
        String columnName = "";
        String insertItem = "";
        int count = 0;
        for (int i = 0; i < fieldArray.length; i++) {
            if (isColumn(fieldArray[i]))
            {
                variableName = fieldArray[i].getName();
                columnName = toColumnName(variableName);
                String variableValue = " ? ";

                params.add(getVariableValue(obj, variableName));
                if (count > 0)
                {
                    tmpSqlItem = tmpSqlItem + ", ";
                    tmpSqlValue = tmpSqlValue + ", ";
                }
                count++;

                tmpSqlItem = tmpSqlItem + columnName;
                tmpSqlValue = tmpSqlValue + variableValue;
            }
        }
        insertItem = " (" + tmpSqlItem + ") values (" + tmpSqlValue + ")";

        return insertItem;
    }

    public static String toBatchInsertItem(Class<?> entityClass, List<?> list, List<List<Object>> params)
            throws Exception
    {
        int listSize = 0;
        if ((entityClass == null) || (list == null) || ((listSize = list.size()) <= 0) || (params == null)) {
            throw new Exception();
        }
        List<Object> paramList = null;
        String tmpSqlItem = "";
        String tmpSqlValue = "";
        String columnName = "";

        String variableName = "";
        String variableValue = " ? ";
        String batchInsertItem = "";

        Field[] fieldArray = entityClass.getDeclaredFields();

        int count = 0;
        for (int i = 0; i < fieldArray.length; i++) {
            if (isColumn(fieldArray[i]))
            {
                columnName = toColumnName(fieldArray[i].getName());
                if (count > 0)
                {
                    tmpSqlItem = tmpSqlItem + ", ";
                    tmpSqlValue = tmpSqlValue + ", ";
                }
                count++;

                tmpSqlItem = tmpSqlItem + columnName;
                tmpSqlValue = tmpSqlValue + variableValue;
            }
        }
        batchInsertItem = " (" + tmpSqlItem + ") values (" + tmpSqlValue + ")";
        for (int i = 0; i < listSize; i++)
        {
            Object obj = list.get(i);
            entityClass = obj.getClass();
            fieldArray = entityClass.getDeclaredFields();
            paramList = new ArrayList();
            for (int j = 0; j < fieldArray.length; j++) {
                if (isColumn(fieldArray[j]))
                {
                    variableName = fieldArray[j].getName();

                    paramList.add(getVariableValue(obj, variableName));
                }
            }
            params.add(paramList);
        }
        return batchInsertItem;
    }

    public static String toBatchInsertCustomItem(Class<?> entityClass, List<?> list, List<List<Object>> params, Map<String, Object> convertor)
            throws Exception
    {
        int listSize = 0;
        if ((entityClass == null) || (list == null) || ((listSize = list.size()) <= 0) || (params == null)) {
            throw new Exception();
        }
        List<Object> paramList = null;
        String tmpSqlItem = "";
        String tmpSqlValue = "";
        String columnName = "";

        String variableName = "";
        String variableValue = " ? ";

        String batchInsertItem = "";

        Field[] fieldArray = entityClass.getDeclaredFields();

        int count = 0;
        for (int i = 0; i < fieldArray.length; i++) {
            if (isColumn(fieldArray[i]))
            {
                variableName = fieldArray[i].getName();
                columnName = toColumnName(variableName);
                if (count > 0)
                {
                    tmpSqlItem = tmpSqlItem + ", ";
                    tmpSqlValue = tmpSqlValue + ", ";
                }
                count++;

                tmpSqlItem = tmpSqlItem + columnName;
                if ((convertor != null) && (convertor.containsKey(variableName))) {
                    tmpSqlValue = tmpSqlValue + convertor.get(variableName);
                } else {
                    tmpSqlValue = tmpSqlValue + variableValue;
                }
            }
        }
        batchInsertItem = " (" + tmpSqlItem + ") values (" + tmpSqlValue + ")";
        for (int i = 0; i < listSize; i++)
        {
            Object obj = list.get(i);
            entityClass = obj.getClass();
            fieldArray = entityClass.getDeclaredFields();
            paramList = new ArrayList();
            for (int j = 0; j < fieldArray.length; j++) {
                if (isColumn(fieldArray[j]))
                {
                    variableName = fieldArray[j].getName();
                    if ((convertor == null) || (!convertor.containsKey(variableName))) {
                        paramList.add(getVariableValue(obj, variableName));
                    }
                }
            }
            params.add(paramList);
        }
        return batchInsertItem;
    }

    public static String toUpdateItem(Object obj, List<Object> params)
            throws Exception
    {
        if ((obj == null) || (params == null)) {
            throw new Exception();
        }
        Class<?> entityClass = obj.getClass();
        Field[] fieldArray = entityClass.getDeclaredFields();

        String updateItem = "";
        String columnName = "";

        int count = 0;
        for (int i = 0; i < fieldArray.length; i++) {
            if (isColumn(fieldArray[i]))
            {
                String variableName = fieldArray[i].getName();
                String variableValue = " ? ";

                params.add(getVariableValue(obj, variableName));
                columnName = toColumnName(variableName);
                if (count > 0) {
                    updateItem = updateItem + ", ";
                }
                count++;

                updateItem = updateItem + columnName + " = " + variableValue + " ";
            }
        }
        return updateItem;
    }

    public static String toUpdateNotNullItem(Object obj, List<Object> params)
            throws Exception
    {
        if ((obj == null) || (params == null)) {
            throw new Exception();
        }
        Class<?> entityClass = obj.getClass();
        Field[] fieldArray = entityClass.getDeclaredFields();

        String updateItem = "";
        String columnName = "";
        int count = 0;
        for (int i = 0; i < fieldArray.length; i++) {
            if (isColumn(fieldArray[i]))
            {
                String variableName = fieldArray[i].getName();
                Object paramObj = getVariableValue(obj, variableName);
                String variableValue = " ? ";
                if (paramObj != null)
                {
                    params.add(paramObj);
                    columnName = toColumnName(variableName);
                    if (count > 0) {
                        updateItem = updateItem + ", ";
                    }
                    updateItem = updateItem + columnName + " = " + variableValue;

                    count++;
                }
            }
        }
        return updateItem;
    }

    public static String toConditionItem(Map<String, Object> condition, List<Object> params)
            throws Exception
    {
        if ((condition == null) || (condition.size() <= 0)) {
            return "";
        }
        if (params == null) {
            throw new Exception();
        }
        String conditionItem = "";

        Iterator<Map.Entry<String, Object>> it = condition.entrySet().iterator();
        while (it.hasNext())
        {
            Map.Entry<String, Object> entry = (Map.Entry)it.next();

            conditionItem = conditionItem + ("".equals(conditionItem) ? " where " : " and ");
            conditionItem = conditionItem + toColumnName(((String)entry.getKey()).toString()) + " = ? ";

            params.add(entry.getValue());
        }
        return conditionItem;
    }

    public static String toIdConditionItem(Class<?> entityClass, Object id, List<Object> params)
            throws Exception
    {
        if ((id == null) || (params == null)) {
            throw new Exception();
        }
        String conditionItem = "";

        Field[] fieldArray = entityClass.getDeclaredFields();
        Field field = null;
        List<String> idNameList = new ArrayList();
        for (int i = 0; i < fieldArray.length; i++) {
            if (isColumn(fieldArray[i]))
            {
                field = fieldArray[i];
                if (field.getAnnotation(Id.class) != null)
                {
                    String variableName = fieldArray[i].getName();

                    conditionItem = conditionItem + ("".equals(conditionItem) ? " where " : " and ");
                    conditionItem = conditionItem + toColumnName(variableName) + " = ? ";

                    idNameList.add(variableName);
                }
            }
        }
        int idNameListSize = 0;
        if ((idNameListSize = idNameList.size()) > 1) {
            if ((id instanceof Map))
            {
                HashMap<?, ?> idMap = (HashMap)id;
                for (int i = 0; i < idNameListSize; i++) {
                    params.add(idMap.get(idNameList.get(i)));
                }
            }
            else
            {
                throw new HandleException("-110002", "查询条件(主键)异常");
            }
        }
        if (idNameListSize <= 0) {
            throw new HandleException("-110002", "查询条件(主键)异常");
        }
        params.add(id);

        return conditionItem;
    }

    public static String toIdConditionItem(Class<?> entityClass, List<Object> idList, List<Object> params)
            throws Exception
    {
        if ((idList == null) || (params == null)) {
            throw new Exception();
        }
        String conditionItem = "";

        Field[] fieldArray = entityClass.getDeclaredFields();
        Field field = null;
        List<String> idNameList = new ArrayList();
        for (int i = 0; i < fieldArray.length; i++) {
            if (isColumn(fieldArray[i]))
            {
                field = fieldArray[i];
                if (field.getAnnotation(Id.class) != null)
                {
                    String variableName = fieldArray[i].getName();

                    conditionItem = conditionItem + ("".equals(conditionItem) ? " where " : " and ");
                    conditionItem = conditionItem + toColumnName(variableName) + " = ? ";

                    idNameList.add(variableName);
                }
            }
        }
        conditionItem = conditionItem + " ) in ( ";

        int idNameListSize = 0;
        if ((idNameListSize = idNameList.size()) > 1)
        {
            int i = 0;
            for (int len = idList.size(); i < len; i++)
            {
                Object id = idList.get(i);
                if ((id instanceof Map))
                {
                    conditionItem = conditionItem + (i == 0 ? " ( " : ", ( ");

                    HashMap<?, ?> idMap = (HashMap)id;
                    for (int j = 0; j < idNameListSize; j++)
                    {
                        conditionItem = conditionItem + (j == 0 ? " ? " : ", ? ");

                        params.add(idMap.get(idNameList.get(j)));
                    }
                    conditionItem = conditionItem + ")";
                }
                else
                {
                    throw new HandleException("-110002", "查询条件(主键)异常");
                }
            }
        }
        if (idNameListSize <= 0) {
            throw new HandleException("-110002", "查询条件(主键)异常");
        }
        int i = 0;
        for (int len = idList.size(); i < len; i++)
        {
            conditionItem = conditionItem + (i == 0 ? " ? " : ", ? ");

            Object id = idList.get(i);
            params.add(id);
        }
        conditionItem = conditionItem + " ) ";

        return conditionItem;
    }

    public static String toFormName(String entityName)
    {
        if (StringUtils.isEmpty(entityName)) {
            return entityName;
        }
        return entityName.substring(0, 1).toLowerCase() + entityName.substring(1);
    }
}
