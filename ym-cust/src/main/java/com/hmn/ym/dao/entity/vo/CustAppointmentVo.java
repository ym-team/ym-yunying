package com.hmn.ym.dao.entity.vo;

import com.hmn.ym.dao.entity.BaseEntity;
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
public class CustAppointmentVo extends BaseEntity {

	/**
	* 顾客id
	*/
	private String consuId;
	/**
	* 顾客姓名
	*/
	private String consuName;
	/**
	* 电话
	*/
	private String consuPhone;
	/**
	* 店家id
	*/
	private Long shopId;
	/**
	* 业务员id
	*/
	private Long bussinessUserId;
	/**
	* 确定项目
	*/
	private String consuConfirmItem;
	/**
	* 预约医院
	*/
	private String consuYuYueHospital;
	/**
	* 预约时间
	*/
	private Date appointmentTime;
	/**
	* 接待员
	*/
	private String jieDaiYuan;
	/**
	* 1 正常  2 不正常
	*/
	private Integer consuStatus;
	/**
	* 备注
	*/
	private String remark;
}
