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
 * @date 2018-11-21 21:53:31
 */
@TableName("qrtz_fired_triggers")
public class QrtzFiredTriggersEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String schedName;
	/**
	 * 
	 */
	private String entryId;
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
	private String instanceName;
	/**
	 * 
	 */
	private Long firedTime;
	/**
	 * 
	 */
	private Long schedTime;
	/**
	 * 
	 */
	private Integer priority;
	/**
	 * 
	 */
	private String state;
	/**
	 * 
	 */
	private String jobName;
	/**
	 * 
	 */
	private String jobGroup;
	/**
	 * 
	 */
	private String isNonconcurrent;
	/**
	 * 
	 */
	private String requestsRecovery;

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
	public void setEntryId(String entryId) {
		this.entryId = entryId;
	}
	/**
	 * 获取：
	 */
	public String getEntryId() {
		return entryId;
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
	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}
	/**
	 * 获取：
	 */
	public String getInstanceName() {
		return instanceName;
	}
	/**
	 * 设置：
	 */
	public void setFiredTime(Long firedTime) {
		this.firedTime = firedTime;
	}
	/**
	 * 获取：
	 */
	public Long getFiredTime() {
		return firedTime;
	}
	/**
	 * 设置：
	 */
	public void setSchedTime(Long schedTime) {
		this.schedTime = schedTime;
	}
	/**
	 * 获取：
	 */
	public Long getSchedTime() {
		return schedTime;
	}
	/**
	 * 设置：
	 */
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	/**
	 * 获取：
	 */
	public Integer getPriority() {
		return priority;
	}
	/**
	 * 设置：
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * 获取：
	 */
	public String getState() {
		return state;
	}
	/**
	 * 设置：
	 */
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	/**
	 * 获取：
	 */
	public String getJobName() {
		return jobName;
	}
	/**
	 * 设置：
	 */
	public void setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup;
	}
	/**
	 * 获取：
	 */
	public String getJobGroup() {
		return jobGroup;
	}
	/**
	 * 设置：
	 */
	public void setIsNonconcurrent(String isNonconcurrent) {
		this.isNonconcurrent = isNonconcurrent;
	}
	/**
	 * 获取：
	 */
	public String getIsNonconcurrent() {
		return isNonconcurrent;
	}
	/**
	 * 设置：
	 */
	public void setRequestsRecovery(String requestsRecovery) {
		this.requestsRecovery = requestsRecovery;
	}
	/**
	 * 获取：
	 */
	public String getRequestsRecovery() {
		return requestsRecovery;
	}
}
