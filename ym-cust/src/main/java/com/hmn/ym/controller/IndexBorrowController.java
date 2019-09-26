package com.hmn.ym.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hmn.ym.common.model.BaseResp;
import com.hmn.ym.dao.entity.po.Category;
import com.hmn.ym.dao.entity.po.CategoryIndex;
import com.hmn.ym.service.ICategoryIndexService;
import com.hmn.ym.service.ICategoryService;
import com.hmn.ym.utils.RespUtil;

import lombok.extern.slf4j.Slf4j;
import tk.mybatis.mapper.entity.Example;

@Slf4j
@Controller
@RequestMapping("borrow/")
public class IndexBorrowController {


	@Autowired
	private ICategoryService categoryService;
	
	@Autowired
	private ICategoryIndexService categoryIndexService;
	
	
	
	@RequestMapping("index.do")
	public String index(HttpServletRequest request, HttpServletResponse response, Model model) {
		log.info("index首页");
		List<Category> list = categoryService.selectAll();
		log.info("{}",list);
		for(int i=0;i<list.size();i++) {
			if("cur".equals(list.get(i).getRemark())) {
				model.addAttribute("dftId", list.get(i).getId());
			}
		}
		model.addAttribute("list",list);
		return "index";
	}
	
	
	/**
	 * 首页获取类别
	 * @param request
	 * @param response
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping("getIndex.do")
	public ResponseEntity<BaseResp>  getIndex(HttpServletRequest request, HttpServletResponse response, Model model ) throws Exception{
		Long categoryId =Long.parseLong(request.getParameter("id"));
		log.info("类别id为：{}",categoryId);
		Example  ex=new Example(CategoryIndex.class);
		ex.createCriteria().andEqualTo("categoryId",categoryId);
		List<CategoryIndex> list = categoryIndexService.selectByExample(ex);
		 return RespUtil.success(list);
	}
	
	
	
	 
}
