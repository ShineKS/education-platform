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
@TableName("qrtz_calendars")
public class QrtzCalendarsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String schedName;
	/**
	 * 
	 */
	private String calendarName;
	/**
	 * 
	 */
	private unknowType calendar;

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
	public void setCalendar(unknowType calendar) {
		this.calendar = calendar;
	}
	/**
	 * 获取：
	 */
	public unknowType getCalendar() {
		return calendar;
	}
}
