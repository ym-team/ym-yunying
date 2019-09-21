package com.hmn.ym.dao.entity.vo;

import com.see.dao.entity.vo.BaseVo;
import lombok.Data;

import java.util.List;
import java.util.Date;

/**
* <p>
*
* </p>
*
* @author xfz
* @since 2018-05-28
*/
@Data
public class CategoryVo extends BaseVo {


	/**
	* 创建者用户id
	*/
	private Long createUserId;

	/**
	* 类别名称
	*/
	private String categoryName;

	/**
	* 状态1有效；0无效
	*/
	private Integer status;

	/**
	* 备注描述
	*/
	private String remark;

	/**
	* 创建时间
	*/
	private Date createTime;

	/**
	* 更新时间
	*/
	private Date updateTime;
}
