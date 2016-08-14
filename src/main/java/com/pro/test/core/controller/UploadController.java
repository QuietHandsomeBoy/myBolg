package com.pro.test.core.controller;

import com.pro.test.core.common.springmvc.entity.RequestResolver;
import com.pro.test.core.util.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

/**
 * Created by hxpeng on 2016/8/15.
 */

@Controller
@RequestMapping(value = "/upload")
public class UploadController {
    /** 上传目录名*/
    private static final String uploadFolderName = "uploadFiles";

    /** 允许上传的扩展名*/
    private static final String [] extensionPermit = {"txt", "xls", "zip"};

    @ResponseBody
    @RequestMapping(value = "/uploadArticleImg.json", method = RequestMethod.POST)
    public boolean uploadArticleImg(@RequestParam("articleImage") CommonsMultipartFile file, RequestResolver requestResolver, String articleId) throws IOException {
        try {
            long startTime = System.currentTimeMillis();   //获取开始时间
            if (!file.isEmpty()) {
                String fileName = file.getOriginalFilename();//获取文件名
                if (checkIsImg(fileName)) {
                    //清除上次上传进度信息
                    String path = FileUtils.createArticleImgPath("bd5328a2d979431d8fa9acef50d5db38");
                    File saveDirectory = new File(path);
                    file.transferTo(new File(saveDirectory, fileName));
                }
            }
            long endTime = System.currentTimeMillis(); //获取结束时间
            System.out.println("上传文件共使用时间：" + (endTime - startTime));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 判断文件是否是图片
     *
     * @param fileName
     * @return
     */
    public boolean checkIsImg(String fileName) {
        try {
            String fileSuffix = fileName.substring(fileName.lastIndexOf('.')).toUpperCase(Locale.US);
            if (fileSuffix.equals(".JPG") || fileSuffix.equals(".GIF") || fileSuffix.equals(".PNG") || fileSuffix.equals(".JPEG")) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }


}
