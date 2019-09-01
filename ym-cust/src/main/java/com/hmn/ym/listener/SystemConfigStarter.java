package com.hmn.ym.listener;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.hmn.ym.service.ICfgParaDetailService;

/**
 * 系统配置
 * @author 
 */
public class SystemConfigStarter implements Starter  {

	private static Logger logger = LoggerFactory
			.getLogger(SystemConfigStarter.class); 
	
	private ICfgParaDetailService cfgParaDetailService;
	/**
	 * 获取spring注入的bean对象  
	 * @param ctx
	 */
	private void initBeans(ServletContext ctx){
		
		WebApplicationContext springContext = WebApplicationContextUtils.getWebApplicationContext(ctx); 
		cfgParaDetailService = (ICfgParaDetailService) springContext.getBean("cfgParaDetailServiceImpl");
	}
	
	@Override
	public void init(ServletContext ctx) {
		initBeans(ctx); //初始化spring bean
		cfgParaDetailService.getAllCfgParaToCach();
		logger.debug("------------load SystemConfig end-------------");
		System.out.println("=====加载配置缓存监听===.....");
	}

}
