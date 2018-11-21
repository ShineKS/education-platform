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
@TableName("qrtz_scheduler_state")
public class QrtzSchedulerStateEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String schedName;
	/**
	 * 
	 */
	private String instanceName;
	/**
	 * 
	 */
	private Long lastCheckinTime;
	/**
	 * 
	 */
	private Long checkinInterval;

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
	public void setLastCheckinTime(Long lastCheckinTime) {
		this.lastCheckinTime = lastCheckinTime;
	}
	/**
	 * 获取：
	 */
	public Long getLastCheckinTime() {
		return lastCheckinTime;
	}
	/**
	 * 设置：
	 */
	public void setCheckinInterval(Long checkinInterval) {
		this.checkinInterval = checkinInterval;
	}
	/**
	 * 获取：
	 */
	public Long getCheckinInterval() {
		return checkinInterval;
	}
}
