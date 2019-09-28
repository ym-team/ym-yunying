package com.hmn.ym.controller;

import com.hmn.ym.dao.entity.po.SaleMan;
import com.hmn.ym.dao.entity.po.User;
import com.hmn.ym.service.ISaleManService;
import com.hmn.ym.utils.Base64Utils;
import com.hmn.ym.utils.CachCfgParaUtil;
import com.hmn.ym.utils.CfgParaUtils;
import com.hmn.ym.utils.upload.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
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
        User user = this.getUser(request);
        model.addAttribute("inviteCode", user.getInviteCode());
        model.addAttribute("pathUrl", CachCfgParaUtil.getCfgCache(CfgParaUtils.SERVER_URL));
        return "user/usercode";
    }

    /**
     * 文件上传
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
