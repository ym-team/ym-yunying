package com.hmn.ym.utils.upload;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 上传文件工具类
 * @author oymw
 *
 */
public class UploadUtils {

	/**
	 * 附件路径
	 */
	public static final String FILE_PATH = "files";
	
	public static String DEFAULT_FORMAT = "yyyy-MM-dd";
	
	/**
	 * 获得上传目录的相对地址
	 * @return
	 */
	public static String getRelatedPath(){
		String filePathDir ="/"+ FILE_PATH +  "/"+formatDate(new Date());
		
		return filePathDir;
	}
	
	/**
	 * 
	 * return yyyy-MM-dd
	 * 
	 * @param date
	 * @return
	 */
	private static String formatDate(Date date) {
		if(date==null){
			return "";
		}
		SimpleDateFormat f = new SimpleDateFormat(DEFAULT_FORMAT);
		String sDate = f.format(date);
		return sDate;
	}

	/**
	 * 获得上传目录的完整路径
	 * @return
	 */
	public static String getRealPath(){
		
		return getRealPath(getRelatedPath());
	}
	/**
	 * 获得上传目录的完整路径
	 * @return
	 */
	public static String getRealPath(String path){
		String path2 = "";
		try {
			path=path.replace("/", "\\");
			Resource resource = new ClassPathResource("");
			path2 = resource.getFile().getAbsolutePath().toString()+path;
			final File pathFile = new File(path2);
			System.out.println(path2);
			if(!pathFile.exists()){
				pathFile.mkdirs();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
//		File pathFile = new File(fileRealPathDir);
//		if(!pathFile.exists()){
//			pathFile.mkdirs();
//		}
		return path2;
	}
}
