package com.hmn.ym.utils;

import org.apache.commons.lang3.time.FastDateFormat;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;

public class FileUtil {
    private static final FastDateFormat ymd = FastDateFormat.getInstance("yyyyMMdd");
    private static final FastDateFormat ymdhms = FastDateFormat.getInstance("yyyyMMddHHmmssSSS");
    private static final String start_path = File.separator + "upload" + File.separator;

    /**
     * @param mFile    文件
     * @param rootPath
     * @return
     */
    public static String upload(MultipartFile mFile, String rootPath) {
        try {
            String savePath = start_path + ymd.format(new Date());
            File saveFile = new File(rootPath + savePath);
            //判断文件父目录是否存在
            if (!saveFile.exists()) {
                saveFile.mkdirs();
            }
            //文件名称
            String filePath = savePath + File.separator + FileUtil.generatorFileName(mFile.getOriginalFilename());
            //保存文件
            mFile.transferTo(new File(rootPath + filePath));
            return filePath;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 生成文件名称
     *
     * @param fileName
     * @return
     */
    private static String generatorFileName(String fileName) {
        return ymdhms.format(new Date()) + InviteCodeGenerator.getRandom(5) + FileUtil.getSuffixName(fileName);
    }

    /**
     * 获取文件后缀名
     *
     * @param fileName
     * @return
     */
    private static String getSuffixName(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }
}
