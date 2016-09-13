package com.pro.test.core.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hxpeng on 2016/9/12.
 */
public class LogUtils {

    private static final Logger logger = LoggerFactory.getLogger(LogUtils.class);

    private static final String LogFilePath = "D:\\logs";

    public static void writeLog(StringBuffer logMsg) {
        FileOutputStream fileOutputStream = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = sdf.format(new Date());
        try {
            if (logMsg == null) {
                return;
            }
            File dirFile = new File(LogFilePath + "\\" + dateStr);
            if (!dirFile.exists() && !dirFile.isDirectory()) {
                dirFile.mkdir();
            }
            StringBuffer sb = new StringBuffer("");
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            sb.append('[' + sdf.format(new Date()) + ']');
            sb.append(logMsg);

            fileOutputStream = new FileOutputStream(dirFile, true);
            fileOutputStream.write(sb.toString().getBytes("UTF-8"));
        } catch (Exception e) {
            logger.error("Exception: ", e);
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                }
            }
        }

    }

}
