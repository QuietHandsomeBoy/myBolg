package com.pro.test.web.admin.dao;

import com.pro.test.core.common.mybatis.dao.GenericDAO;
import com.pro.test.web.admin.dao.mapper.TbHxpUserLoginMapper;
import com.pro.test.web.admin.entity.TbHxpUserLogin;
import org.springframework.stereotype.Repository;

/**
 * Created by hxpeng on 2016/7/5.
 */

@Repository
public class TbHxpUserLoginDao extends GenericDAO<TbHxpUserLogin, TbHxpUserLoginMapper> {


    public String test(){
        mapper.selectByPrimaryKey("111");
        return "";
    }



}
