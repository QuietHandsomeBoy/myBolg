package com.pro.test.web.service.impl;

import com.pro.test.web.dao.TbHxpArticleContentMapper;
import com.pro.test.web.service.TbHxpArticleContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hxpeng on 2016/6/16.
 */

@Service
public class TbHxpArticleContentServiceImpl implements TbHxpArticleContentService {

    @Autowired
    private TbHxpArticleContentMapper tbHxpArticleContentMapper;

    @Override
    public int test() {
        return 0;
    }
}
