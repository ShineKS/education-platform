package com.little.edu.appweb.modules.smallapp.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 学员表
 * 
 * @author huangqi
 * @email xxx@gmail.com
 * @date 2018-11-22 16:17:30
 */
@TableName("student")
public class StudentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 备注名称,机构给孩子起的别名
	 */
	private String remarkName;
	/**
	 * 
	 */
	private Long orgId;
	/**
	 * 孩子表id
	 */
	private Long childId;
	/**
	 * 当前班级id
	 */
	private Long classId;
	/**
	 * 
	 */
	private String note;
	/**
	 * 创建人id,表sys_user
	 */
	private Long createrId;
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
	 * 设置：备注名称,机构给孩子起的别名
	 */
	public void setRemarkName(String remarkName) {
		this.remarkName = remarkName;
	}
	/**
	 * 获取：备注名称,机构给孩子起的别名
	 */
	public String getRemarkName() {
		return remarkName;
	}
	/**
	 * 设置：
	 */
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
	/**
	 * 获取：
	 */
	public Long getOrgId() {
		return orgId;
	}
	/**
	 * 设置：孩子表id
	 */
	public void setChildId(Long childId) {
		this.childId = childId;
	}
	/**
	 * 获取：孩子表id
	 */
	public Long getChildId() {
		return childId;
	}
	/**
	 * 设置：当前班级id
	 */
	public void setClassId(Long classId) {
		this.classId = classId;
	}
	/**
	 * 获取：当前班级id
	 */
	public Long getClassId() {
		return classId;
	}
	/**
	 * 设置：
	 */
	public void setNote(String note) {
		this.note = note;
	}
	/**
	 * 获取：
	 */
	public String getNote() {
		return note;
	}
	/**
	 * 设置：创建人id,表sys_user
	 */
	public void setCreaterId(Long createrId) {
		this.createrId = createrId;
	}
	/**
	 * 获取：创建人id,表sys_user
	 */
	public Long getCreaterId() {
		return createrId;
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
