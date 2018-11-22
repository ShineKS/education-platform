package com.little.edu.appweb.modules.smallapp.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 成长之路报告表
 * 
 * @author huangqi
 * @email xxx@gmail.com
 * @date 2018-11-22 16:17:30
 */
@TableName("grow_stage_item_score")
public class GrowStageItemScoreEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 成长阶段的id
	 */
	private Long stageId;
	/**
	 * 报告项名称
	 */
	private String itemName;
	/**
	 * 报告项得分
	 */
	private Integer itemScore;
	/**
	 * 1-阶段报告 2-家长评价
	 */
	private Integer itemType;

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
	 * 设置：成长阶段的id
	 */
	public void setStageId(Long stageId) {
		this.stageId = stageId;
	}
	/**
	 * 获取：成长阶段的id
	 */
	public Long getStageId() {
		return stageId;
	}
	/**
	 * 设置：报告项名称
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	/**
	 * 获取：报告项名称
	 */
	public String getItemName() {
		return itemName;
	}
	/**
	 * 设置：报告项得分
	 */
	public void setItemScore(Integer itemScore) {
		this.itemScore = itemScore;
	}
	/**
	 * 获取：报告项得分
	 */
	public Integer getItemScore() {
		return itemScore;
	}
	/**
	 * 设置：1-阶段报告 2-家长评价
	 */
	public void setItemType(Integer itemType) {
		this.itemType = itemType;
	}
	/**
	 * 获取：1-阶段报告 2-家长评价
	 */
	public Integer getItemType() {
		return itemType;
	}
}
