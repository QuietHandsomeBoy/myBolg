package com.pro.test.core.util;

import com.pro.test.core.common.springmvc.context.SpringContextHolder;

import java.io.File;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.UUID;

/**
 * Created by hxpeng on 2016/8/16.
 */
public class FileUtils {


    /**
     * 图片上传，返回上传具体路劲
     * @param articleId
     * @param fileName
     * @return
     */
    public static String getUploadPath(String articleId, String fileName) {
        StringBuffer buffer = new StringBuffer();
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(new Date());
        buffer.append(articleId)
                .append("/").append(UUID.randomUUID().toString())
                .append(fileName.substring(fileName.lastIndexOf('.')).toLowerCase(Locale.US));


        return buffer.toString();
    }


    /**
     * 根据文章ID创建上传图片文件路劲
     * @param articleId
     * @return
     */
    public static String createArticleImgPath(String articleId){
        if(StringUtils.checkIsEmpty(articleId)){
            return null;
        }
        File file = new File(SpringContextHolder.getSystemConfigSevice().getUploadImgPath() + "/" + articleId);
        if(!file.exists() && !file.isDirectory()){
            file.mkdir();
        }
        return file.getPath();
    }


}
