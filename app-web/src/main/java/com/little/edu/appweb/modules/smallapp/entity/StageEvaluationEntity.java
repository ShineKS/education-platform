package com.little.edu.appweb.modules.smallapp.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 家长对于每个日记每个阶段的成长之路评价
 * 
 * @author huangqi
 * @email xxx@gmail.com
 * @date 2018-11-22 16:17:30
 */
@TableName("stage_evaluation")
public class StageEvaluationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 成长阶段id
	 */
	private Long stageId;
	/**
	 * 家长的openid
	 */
	private String openId;
	/**
	 * 
	 */
	private String remark;
	/**
	 * 知识吸收百分比，储存整数
	 */
	private Integer acceptPercent;
	/**
	 * 1-阶段评价 2-日记总评
	 */
	private Integer type;
	/**
	 * 
	 */
	private Date createDate;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：成长阶段id
	 */
	public void setStageId(Long stageId) {
		this.stageId = stageId;
	}
	/**
	 * 获取：成长阶段id
	 */
	public Long getStageId() {
		return stageId;
	}
	/**
	 * 设置：家长的openid
	 */
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	/**
	 * 获取：家长的openid
	 */
	public String getOpenId() {
		return openId;
	}
	/**
	 * 设置：
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：知识吸收百分比，储存整数
	 */
	public void setAcceptPercent(Integer acceptPercent) {
		this.acceptPercent = acceptPercent;
	}
	/**
	 * 获取：知识吸收百分比，储存整数
	 */
	public Integer getAcceptPercent() {
		return acceptPercent;
	}
	/**
	 * 设置：1-阶段评价 2-日记总评
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：1-阶段评价 2-日记总评
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * 获取：
	 */
	public Date getCreateDate() {
		return createDate;
	}
}
