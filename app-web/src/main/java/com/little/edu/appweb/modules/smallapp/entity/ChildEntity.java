package com.little.edu.appweb.modules.smallapp.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 记录每一个孩子的实体
 * 
 * @author huangqi
 * @email xxx@gmail.com
 * @date 2018-11-22 16:17:30
 */
@TableName("child")
public class ChildEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 
	 */
	private String name;
	/**
	 * 0-未知 1-男 2-女 3-其他
	 */
	private Integer sex;
	/**
	 * 
	 */
	private Integer age;
	/**
	 * 
	 */
	private Long guarderId;
	/**
	 * 
	 */
	private Long headPicId;
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
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：0-未知 1-男 2-女 3-其他
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	/**
	 * 获取：0-未知 1-男 2-女 3-其他
	 */
	public Integer getSex() {
		return sex;
	}
	/**
	 * 设置：
	 */
	public void setAge(Integer age) {
		this.age = age;
	}
	/**
	 * 获取：
	 */
	public Integer getAge() {
		return age;
	}
	/**
	 * 设置：
	 */
	public void setGuarderId(Long guarderId) {
		this.guarderId = guarderId;
	}
	/**
	 * 获取：
	 */
	public Long getGuarderId() {
		return guarderId;
	}
	/**
	 * 设置：
	 */
	public void setHeadPicId(Long headPicId) {
		this.headPicId = headPicId;
	}
	/**
	 * 获取：
	 */
	public Long getHeadPicId() {
		return headPicId;
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
