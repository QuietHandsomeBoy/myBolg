package com.pro.test.core.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by hxpeng on 2016/8/16.
 */

@Service
public class SystemConfigSevice {


    private String uploadImgPath;

    @Value("${article.upload.path}")
    public void setUploadImgPath(String uploadImgPath) {
        this.uploadImgPath = uploadImgPath;
    }

    public String getUploadImgPath() {
        return uploadImgPath;
    }
}
