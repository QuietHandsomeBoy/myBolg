package com.pro.test.web.admin.service;

import com.pro.test.core.common.mybatis.service.SimpleManager;
import com.pro.test.web.dao.TbHxpTagsDao;
import com.pro.test.web.entity.TbHxpTags;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hxpeng on 2016/7/1.
 */
@Service
public class TbHxpTagsManager extends SimpleManager<TbHxpTags, TbHxpTagsDao> {

    public List<TbHxpTags> findAllByCondition(TbHxpTags tbHxpTags){
        return this.dao.findAllByCondition(tbHxpTags);
    }

    @Cacheable(value="articleTagsCache",key="#id")
    public TbHxpTags findOneByID(String id) throws Exception {
        return this.dao.findOneById(id);
    }

}
