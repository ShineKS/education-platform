package com.little.edu.appweb.modules.smallapp.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 记录每个成长日记的阶段内容
 * 
 * @author huangqi
 * @email xxx@gmail.com
 * @date 2018-11-22 16:17:30
 */
@TableName("grow_stage")
public class GrowStageEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 
	 */
	private Long orgId;
	/**
	 * 成长日记id
	 */
	private Long diaryId;
	/**
	 * stage_score
	 */
	private Integer stageScore;
	/**
	 * 机构的阶段评价
	 */
	private String stageRemark;
	/**
	 * 机构填写的知识点
	 */
	private String knowledgePoint;
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
	 * 设置：
	 */
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
	/**
	 * 获取：
	 */
	public Long getOrgId() {
		return orgId;
	}
	/**
	 * 设置：成长日记id
	 */
	public void setDiaryId(Long diaryId) {
		this.diaryId = diaryId;
	}
	/**
	 * 获取：成长日记id
	 */
	public Long getDiaryId() {
		return diaryId;
	}
	/**
	 * 设置：stage_score
	 */
	public void setStageScore(Integer stageScore) {
		this.stageScore = stageScore;
	}
	/**
	 * 获取：stage_score
	 */
	public Integer getStageScore() {
		return stageScore;
	}
	/**
	 * 设置：机构的阶段评价
	 */
	public void setStageRemark(String stageRemark) {
		this.stageRemark = stageRemark;
	}
	/**
	 * 获取：机构的阶段评价
	 */
	public String getStageRemark() {
		return stageRemark;
	}
	/**
	 * 设置：机构填写的知识点
	 */
	public void setKnowledgePoint(String knowledgePoint) {
		this.knowledgePoint = knowledgePoint;
	}
	/**
	 * 获取：机构填写的知识点
	 */
	public String getKnowledgePoint() {
		return knowledgePoint;
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
