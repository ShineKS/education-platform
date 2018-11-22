package com.little.edu.appweb.modules.smallapp.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 公司表
 * 
 * @author huangqi
 * @email xxx@gmail.com
 * @date 2018-11-22 16:17:30
 */
@TableName("org")
public class OrgEntity implements Serializable {
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
	 * 
	 */
	private Date createDate;
	/**
	 * 0-正常 
	 */
	private Integer status;
	/**
	 * 对应attach表的id
	 */
	private Long logoId;

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
	/**
	 * 设置：0-正常 
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：0-正常 
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：对应attach表的id
	 */
	public void setLogoId(Long logoId) {
		this.logoId = logoId;
	}
	/**
	 * 获取：对应attach表的id
	 */
	public Long getLogoId() {
		return logoId;
	}
}
