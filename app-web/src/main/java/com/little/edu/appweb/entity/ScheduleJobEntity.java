package com.little.edu.appweb.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 定时任务
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 21:53:24
 */
@TableName("schedule_job")
public class ScheduleJobEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 任务id
	 */
	@TableId
	private Long jobId;
	/**
	 * spring bean名称
	 */
	private String beanName;
	/**
	 * 方法名
	 */
	private String methodName;
	/**
	 * 参数
	 */
	private String params;
	/**
	 * cron表达式
	 */
	private String cronExpression;
	/**
	 * 任务状态  0：正常  1：暂停
	 */
	private Integer status;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 设置：任务id
	 */
	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}
	/**
	 * 获取：任务id
	 */
	public Long getJobId() {
		return jobId;
	}
	/**
	 * 设置：spring bean名称
	 */
	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}
	/**
	 * 获取：spring bean名称
	 */
	public String getBeanName() {
		return beanName;
	}
	/**
	 * 设置：方法名
	 */
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	/**
	 * 获取：方法名
	 */
	public String getMethodName() {
		return methodName;
	}
	/**
	 * 设置：参数
	 */
	public void setParams(String params) {
		this.params = params;
	}
	/**
	 * 获取：参数
	 */
	public String getParams() {
		return params;
	}
	/**
	 * 设置：cron表达式
	 */
	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}
	/**
	 * 获取：cron表达式
	 */
	public String getCronExpression() {
		return cronExpression;
	}
	/**
	 * 设置：任务状态  0：正常  1：暂停
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：任务状态  0：正常  1：暂停
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
}
