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
@TableName("qrtz_job_details")
public class QrtzJobDetailsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String schedName;
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
	private String jobClassName;
	/**
	 * 
	 */
	private String isDurable;
	/**
	 * 
	 */
	private String isNonconcurrent;
	/**
	 * 
	 */
	private String isUpdateData;
	/**
	 * 
	 */
	private String requestsRecovery;
	/**
	 * 
	 */
//	private unknowType jobData;

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
	public void setJobClassName(String jobClassName) {
		this.jobClassName = jobClassName;
	}
	/**
	 * 获取：
	 */
	public String getJobClassName() {
		return jobClassName;
	}
	/**
	 * 设置：
	 */
	public void setIsDurable(String isDurable) {
		this.isDurable = isDurable;
	}
	/**
	 * 获取：
	 */
	public String getIsDurable() {
		return isDurable;
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
	public void setIsUpdateData(String isUpdateData) {
		this.isUpdateData = isUpdateData;
	}
	/**
	 * 获取：
	 */
	public String getIsUpdateData() {
		return isUpdateData;
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
	/**
	 * 设置：
	 */
//	public void setJobData(unknowType jobData) {
//		this.jobData = jobData;
//	}

	/**
	 * 获取：
	 */
//	public unknowType getJobData() {
//		return jobData;
//	}
}
