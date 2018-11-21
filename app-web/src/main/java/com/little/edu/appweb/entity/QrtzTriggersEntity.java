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
 * @date 2018-11-21 21:50:52
 */
@TableName("qrtz_triggers")
public class QrtzTriggersEntity implements Serializable {
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
	private String jobName;
	/**
	 * 
	 */
	private String jobGroup;
	/**
	 * 
	 */
	private String description;
	/**
	 * 
	 */
	private Long nextFireTime;
	/**
	 * 
	 */
	private Long prevFireTime;
	/**
	 * 
	 */
	private Integer priority;
	/**
	 * 
	 */
	private String triggerState;
	/**
	 * 
	 */
	private String triggerType;
	/**
	 * 
	 */
	private Long startTime;
	/**
	 * 
	 */
	private Long endTime;
	/**
	 * 
	 */
	private String calendarName;
	/**
	 * 
	 */
	private Integer misfireInstr;
	/**
	 * 
	 */
	private unknowType jobData;

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
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * 获取：
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * 设置：
	 */
	public void setNextFireTime(Long nextFireTime) {
		this.nextFireTime = nextFireTime;
	}
	/**
	 * 获取：
	 */
	public Long getNextFireTime() {
		return nextFireTime;
	}
	/**
	 * 设置：
	 */
	public void setPrevFireTime(Long prevFireTime) {
		this.prevFireTime = prevFireTime;
	}
	/**
	 * 获取：
	 */
	public Long getPrevFireTime() {
		return prevFireTime;
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
	public void setTriggerState(String triggerState) {
		this.triggerState = triggerState;
	}
	/**
	 * 获取：
	 */
	public String getTriggerState() {
		return triggerState;
	}
	/**
	 * 设置：
	 */
	public void setTriggerType(String triggerType) {
		this.triggerType = triggerType;
	}
	/**
	 * 获取：
	 */
	public String getTriggerType() {
		return triggerType;
	}
	/**
	 * 设置：
	 */
	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}
	/**
	 * 获取：
	 */
	public Long getStartTime() {
		return startTime;
	}
	/**
	 * 设置：
	 */
	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}
	/**
	 * 获取：
	 */
	public Long getEndTime() {
		return endTime;
	}
	/**
	 * 设置：
	 */
	public void setCalendarName(String calendarName) {
		this.calendarName = calendarName;
	}
	/**
	 * 获取：
	 */
	public String getCalendarName() {
		return calendarName;
	}
	/**
	 * 设置：
	 */
	public void setMisfireInstr(Integer misfireInstr) {
		this.misfireInstr = misfireInstr;
	}
	/**
	 * 获取：
	 */
	public Integer getMisfireInstr() {
		return misfireInstr;
	}
	/**
	 * 设置：
	 */
	public void setJobData(unknowType jobData) {
		this.jobData = jobData;
	}
	/**
	 * 获取：
	 */
	public unknowType getJobData() {
		return jobData;
	}
}
