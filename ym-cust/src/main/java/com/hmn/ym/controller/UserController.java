package com.hmn.ym.controller;

import com.hmn.ym.dao.entity.po.SaleMan;
import com.hmn.ym.dao.entity.po.User;
import com.hmn.ym.service.ISaleManService;
import com.hmn.ym.utils.Base64Utils;
import com.hmn.ym.utils.SpringUtils;
import com.hmn.ym.utils.upload.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("user/")
public class UserController extends BaseController {
    @Autowired
    private ISaleManService saleManService;

    @RequestMapping("userIndex.do")
    public String userIndex() {
        return "user/userIndex";
    }

    @RequestMapping(value = "userInfoView.do")
    public String userInfoView(HttpServletRequest request, Model model) {
        User user = this.getUser(request);
        SaleMan saleMan = saleManService.getByUserId(user.getId());

        model.addAttribute("saleMan", saleMan);

        return "user/userInfo";
    }

    @RequestMapping(value = "userCode.do")
    public String userCode(HttpServletRequest request, Model model) {
        Resource resource = new ClassPathResource("");
        String path2 = "";
        try {
            path2 = resource.getFile().getAbsolutePath().toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("pathUrl", path2);
        return "user/usercode";
    }

    /**
     * 根据用户邀请链接生成二维码
     *
     * @param request
     * @param response
     * @param model
     */
    @RequestMapping("createImg.do")
    public void createImg(HttpServletRequest request, HttpServletResponse response, Model model) {
        String code = "500";
        String msg = "";
        String path = request.getContextPath();
        String uid = "123";
        // 二维码扫描跳转链接
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/web/toRegister.do?u=" + uid;
        try {
//			String fileSufix = UploadUtils.getRelatedPath();
//			String str = "/" +uid+ "-" + UUID.randomUUID().toString() + ".png";
            // 二维码文件路径
//			String twoCodeUrl = UploadUtils.getRealPath() + str.replace("/", "\\");
            // 生成一个二维码
//			QRCodeUtil.encode(basePath, null, twoCodeUrl, true);
            // 把邀请用户二维码存入数据库
            msg = "fileSufix + str";
//			msg = fileSufix + str;
//			msg = twoCodeUrl;
            code = "200";
        } catch (Exception e) {
            logger.error("createImg error " + e.getMessage(), e);
        }
        SpringUtils.renderJsonResult(response, code, msg);
    }


    /**
     * @param filepath        base64
     * @param suffix          后缀文件
     * @param fileImagePrType 文件类型
     * @return
     * @throws Exception
     */
    @RequestMapping("uploadFiles")
    @ResponseBody
    public String uploadFiles(HttpServletRequest request, String filepath, String suffix, String fileImagePrType) throws Exception {
        String url = "";
        suffix = suffix.substring(suffix.lastIndexOf("/") + 1);

        /** 构建图片保存的目录 **/
        String filePathDir = UploadUtils.getRelatedPath();
        /** 得到图片保存目录的真实路径 **/
        String fileRealPathDir = UploadUtils.getRealPath();

        // String fileRealPathDir = fileRealPathDir(request);
        /**使用UUID生成文件名称**/
        String fileImageName = UUID.randomUUID().toString() + fileImagePrType + "." + suffix;// 构建文件名称
        /** 拼成完整的文件保存路径加文件 **/
        String fileUrl = fileRealPathDir + File.separator + fileImageName;
        Base64Utils utils = Base64Utils.getInstance();
        System.out.println(fileUrl + "====文件路径");
        boolean bln = utils.base64ToFile(filepath, new File(fileUrl));
        if (bln) {
            url = filePathDir + "/" + fileImageName;
        }
        return url;
    }

}
