package com.hmn.ym.controller;

import com.hmn.ym.common.model.BaseResp;
import com.hmn.ym.dao.entity.po.SaleMan;
import com.hmn.ym.dao.entity.po.User;
import com.hmn.ym.dao.entity.vo.RealNameAuthVo;
import com.hmn.ym.service.ISaleManService;
import com.hmn.ym.utils.CachCfgParaUtil;
import com.hmn.ym.utils.CfgParaUtils;
import com.hmn.ym.utils.FileUtil;
import com.hmn.ym.utils.RespUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("user/")
public class UserController extends BaseController {
    @Autowired
    private ISaleManService saleManService;

    @Value("${file.local.path}")
    private String localFilePath;

    @Value("${file.local.prefix}")
    public String localFilePrefix;

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

	/*
	 * @RequestMapping(value = "userCode.do") public String
	 * userCode(HttpServletRequest request, Model model) { User user =
	 * this.getUser(request); model.addAttribute("inviteCode",
	 * user.getInviteCode()); model.addAttribute("pathUrl",
	 * CachCfgParaUtil.getCfgCache(CfgParaUtils.SERVER_URL)); return
	 * "user/userInviteCode"; }
	 */

    @RequestMapping("/realNameAuth.do")
    public ResponseEntity<BaseResp> realNameAuth(RealNameAuthVo vo) {
        saleManService.realNameAuth(vo);
        return RespUtil.success();
    }

    @RequestMapping("/imageUpload")
    public ResponseEntity<BaseResp> imageUpload(@RequestParam("fileName") MultipartFile file) {
        //上传
        String imagePath = FileUtil.upload(file, localFilePath);

        String path = localFilePrefix + imagePath;

        return RespUtil.success(path.replaceAll("\\\\", "/"));
    }
}
