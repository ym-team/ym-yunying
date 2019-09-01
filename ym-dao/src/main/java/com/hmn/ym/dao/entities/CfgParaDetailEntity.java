package com.hmn.ym.dao.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


/**
 * @author ouyangmw
 * @date [Thu Mar 07 11:30:17 CST 2019]
 * @desc 功能:本类cfg_para_detail数据DataBean类
 */

@Table(name = "cfg_para_detail")
@Getter@Setter
public class CfgParaDetailEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
			  
	/** 
	* 主键ID
	*/
	protected String pkId;
	  
	/** 
	* 参数键
	*/
	protected String paraKey;
	  
	/** 
	* 参数值
	*/
	protected String paraValue;
	  
	/** 
	* 参数代码
	*/
	protected String paraCode;
	  
	/** 
	* 参数名称
	*/
	protected String paraName;
	  
	/** 
	* 参数描述
	*/
	protected String paraDesc;
	  
	/** 
	* 状态 0无效;1有效
	*/
	protected int state;
	  
	/** 
	* 创建时间
	*/
	protected Date createTime;
	  
	/** 
	* 修改时间
	*/
	protected Date upTime;
	  
	/** 
	* 备注
	*/
	protected String remarks;
     
}