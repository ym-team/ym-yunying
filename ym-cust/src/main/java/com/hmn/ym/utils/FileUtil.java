package com.hmn.ym.utils;

import org.apache.commons.lang3.time.FastDateFormat;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;

public class FileUtil {
    private static final FastDateFormat ymd = FastDateFormat.getInstance("yyyyMMdd");
    private static final FastDateFormat ymdhms = FastDateFormat.getInstance("yyyyMMddHHmmssSSS");
    private static final String start_path = "\\upload\\";

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
            String filePath = savePath + "\\" + FileUtil.getFileName(mFile);
            //保存文件
            mFile.transferTo(new File(rootPath + filePath));
            return filePath;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取文件后缀名
     *
     * @param file
     * @return
     */
    private static String getSuffixName(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        return fileName.substring(fileName.lastIndexOf("."));
    }

    public static String getSaveRootPath() {
        String rootPath = "";
        try {
            String root = System.getProperty("user.dir");
            File file = new File(root, "\\src\\main\\webapp\\upload");
            if (!file.exists()) {
                file.mkdirs();
            }
            rootPath = file.getPath();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rootPath;
    }

    public static boolean isImg(MultipartFile file) {
        String fileType = file.getContentType();
        if (fileType.equals("image/jpeg") || fileType.equals("image/png") || fileType.equals("image/jpeg")) {
            return true;
        }
        return false;
    }

    public static String getFileName(MultipartFile file) {
        return ymdhms.format(new Date()) + InviteCodeGenerator.getRandom(5) + FileUtil.getSuffixName(file);
    }
}
