package com.hmn.ym.controller;

import com.hmn.ym.common.Constants;
import com.hmn.ym.dao.entity.po.SaleMan;
import com.hmn.ym.dao.entity.po.User;
import com.hmn.ym.service.ISaleManService;
import com.hmn.ym.utils.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        User user = (User) request.getSession().getAttribute(Constants.ADMIN_USER_SESSION);
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
}
