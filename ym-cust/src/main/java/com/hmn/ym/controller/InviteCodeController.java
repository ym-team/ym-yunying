package com.hmn.ym.controller;

import java.io.File;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hmn.ym.dao.entity.po.User;
import com.hmn.ym.utils.CachCfgParaUtil;
import com.hmn.ym.utils.CfgParaUtils;
import com.hmn.ym.utils.RespUtil;

import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;



@Controller
@RequestMapping("inviteCode/")
public class InviteCodeController extends BaseController {
	
	@Value("${file.local.path}")
    private String localFilePath;

    @Value("${file.local.prefix}")
    public String localFilePrefix;

    private static final String start_path = "\\inviteCode\\qrcode";
	/**
     * 我的二维码
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "userInviteCode.do")
    public String userCode(HttpServletRequest request, Model model) {
        User user = this.getUser(request);
       String servieUrl = CachCfgParaUtil.getCfgCache(CfgParaUtils.SERVER_URL)+"/toRegister.do?u="+user.getInviteCode();
      // 生成指定url对应的二维码到文件，宽和高都是300像素
    	String savePath = start_path ;
        File saveFile = new File(localFilePath + savePath);
        //判断文件父目录是否存在
        if (!saveFile.exists()) {
            saveFile.mkdirs();
        }
        String fileName ="qrcode"+user.getInviteCode()+".jpg";
        String inviteCodeUrl = savePath+ "\\" +fileName;
        QrCodeUtil.generate(servieUrl, 300, 300, FileUtil.file(localFilePath+inviteCodeUrl));
        String path = localFilePrefix +inviteCodeUrl;
        path = path.replaceAll("\\\\", "/");
         System.out.println(path);
        model.addAttribute("inviteCodeUrl", path);
        model.addAttribute("inviteCode", user.getInviteCode());
        model.addAttribute("pathUrl", CachCfgParaUtil.getCfgCache(CfgParaUtils.SERVER_URL));
        return "user/userInviteCode";
    }
   
    public static void main(String args[]) {
    	// 生成指定url对应的二维码到文件，宽和高都是300像素
//    	String savePath = start_path ;
//        File saveFile = new File("E:/workspace-git/ym-yunying/ym-cust" + savePath);
//        //判断文件父目录是否存在
//        if (!saveFile.exists()) {
//            saveFile.mkdirs();
//        }
//        String fileName ="qrcode"+1+".jpg";
//        String inviteCodeUrl = saveFile+ "\\" +fileName;
//        QrCodeUtil.generate("http://hutool.cn/", 300, 300, FileUtil.file(inviteCodeUrl));
//        String path = "http://localhost:8093/statics/" + fileName;
//        path.replaceAll("\\\\", "/");
//         System.out.println(path);
         
         String decode = QrCodeUtil.decode(FileUtil.file("E:\\workspace-git\\ym-yunying\\ym-cust\\inviteCode\\qrcode\\qrcode79487101.jpg"));
         System.out.println(decode);
    }
    
    
}
