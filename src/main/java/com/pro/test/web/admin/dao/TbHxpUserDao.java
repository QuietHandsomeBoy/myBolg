package com.pro.test.web.admin.dao;

import com.pro.test.core.common.mybatis.dao.GenericDAO;
import com.pro.test.web.admin.dao.mapper.TbHxpUserMapper;
import com.pro.test.web.admin.entity.TbHxpUser;
import org.springframework.stereotype.Repository;

/**
 * Created by hxpeng on 2016/7/5.
 */

@Repository
public class TbHxpUserDao extends GenericDAO<TbHxpUser, TbHxpUserMapper> {


    public String test(){
        mapper.selectByPrimaryKey("111");
        return "";
    }



}
