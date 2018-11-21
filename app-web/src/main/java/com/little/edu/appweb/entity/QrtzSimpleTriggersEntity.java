package com.little.edu.appweb.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 21:53:24
 */
@TableName("qrtz_simple_triggers")
public class QrtzSimpleTriggersEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String schedName;
	/**
	 * 
	 */
	private String triggerName;
	/**
	 * 
	 */
	private String triggerGroup;
	/**
	 * 
	 */
	private Long repeatCount;
	/**
	 * 
	 */
	private Long repeatInterval;
	/**
	 * 
	 */
	private Long timesTriggered;

	/**
	 * 设置：
	 */
	public void setSchedName(String schedName) {
		this.schedName = schedName;
	}
	/**
	 * 获取：
	 */
	public String getSchedName() {
		return schedName;
	}
	/**
	 * 设置：
	 */
	public void setTriggerName(String triggerName) {
		this.triggerName = triggerName;
	}
	/**
	 * 获取：
	 */
	public String getTriggerName() {
		return triggerName;
	}
	/**
	 * 设置：
	 */
	public void setTriggerGroup(String triggerGroup) {
		this.triggerGroup = triggerGroup;
	}
	/**
	 * 获取：
	 */
	public String getTriggerGroup() {
		return triggerGroup;
	}
	/**
	 * 设置：
	 */
	public void setRepeatCount(Long repeatCount) {
		this.repeatCount = repeatCount;
	}
	/**
	 * 获取：
	 */
	public Long getRepeatCount() {
		return repeatCount;
	}
	/**
	 * 设置：
	 */
	public void setRepeatInterval(Long repeatInterval) {
		this.repeatInterval = repeatInterval;
	}
	/**
	 * 获取：
	 */
	public Long getRepeatInterval() {
		return repeatInterval;
	}
	/**
	 * 设置：
	 */
	public void setTimesTriggered(Long timesTriggered) {
		this.timesTriggered = timesTriggered;
	}
	/**
	 * 获取：
	 */
	public Long getTimesTriggered() {
		return timesTriggered;
	}
}
