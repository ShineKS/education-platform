package com.little.edu.appweb.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 21:53:24
 */
@TableName("qrtz_simprop_triggers")
public class QrtzSimpropTriggersEntity implements Serializable {
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
	private String strProp1;
	/**
	 * 
	 */
	private String strProp2;
	/**
	 * 
	 */
	private String strProp3;
	/**
	 * 
	 */
	private Integer intProp1;
	/**
	 * 
	 */
	private Integer intProp2;
	/**
	 * 
	 */
	private Long longProp1;
	/**
	 * 
	 */
	private Long longProp2;
	/**
	 * 
	 */
	private BigDecimal decProp1;
	/**
	 * 
	 */
	private BigDecimal decProp2;
	/**
	 * 
	 */
	private String boolProp1;
	/**
	 * 
	 */
	private String boolProp2;

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
	public void setStrProp1(String strProp1) {
		this.strProp1 = strProp1;
	}
	/**
	 * 获取：
	 */
	public String getStrProp1() {
		return strProp1;
	}
	/**
	 * 设置：
	 */
	public void setStrProp2(String strProp2) {
		this.strProp2 = strProp2;
	}
	/**
	 * 获取：
	 */
	public String getStrProp2() {
		return strProp2;
	}
	/**
	 * 设置：
	 */
	public void setStrProp3(String strProp3) {
		this.strProp3 = strProp3;
	}
	/**
	 * 获取：
	 */
	public String getStrProp3() {
		return strProp3;
	}
	/**
	 * 设置：
	 */
	public void setIntProp1(Integer intProp1) {
		this.intProp1 = intProp1;
	}
	/**
	 * 获取：
	 */
	public Integer getIntProp1() {
		return intProp1;
	}
	/**
	 * 设置：
	 */
	public void setIntProp2(Integer intProp2) {
		this.intProp2 = intProp2;
	}
	/**
	 * 获取：
	 */
	public Integer getIntProp2() {
		return intProp2;
	}
	/**
	 * 设置：
	 */
	public void setLongProp1(Long longProp1) {
		this.longProp1 = longProp1;
	}
	/**
	 * 获取：
	 */
	public Long getLongProp1() {
		return longProp1;
	}
	/**
	 * 设置：
	 */
	public void setLongProp2(Long longProp2) {
		this.longProp2 = longProp2;
	}
	/**
	 * 获取：
	 */
	public Long getLongProp2() {
		return longProp2;
	}
	/**
	 * 设置：
	 */
	public void setDecProp1(BigDecimal decProp1) {
		this.decProp1 = decProp1;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getDecProp1() {
		return decProp1;
	}
	/**
	 * 设置：
	 */
	public void setDecProp2(BigDecimal decProp2) {
		this.decProp2 = decProp2;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getDecProp2() {
		return decProp2;
	}
	/**
	 * 设置：
	 */
	public void setBoolProp1(String boolProp1) {
		this.boolProp1 = boolProp1;
	}
	/**
	 * 获取：
	 */
	public String getBoolProp1() {
		return boolProp1;
	}
	/**
	 * 设置：
	 */
	public void setBoolProp2(String boolProp2) {
		this.boolProp2 = boolProp2;
	}
	/**
	 * 获取：
	 */
	public String getBoolProp2() {
		return boolProp2;
	}
}
