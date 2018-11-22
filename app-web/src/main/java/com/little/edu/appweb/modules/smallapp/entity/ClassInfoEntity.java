package com.little.edu.appweb.modules.smallapp.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author huangqi
 * @email xxx@gmail.com
 * @date 2018-11-22 16:17:30
 */
@TableName("class_info")
public class ClassInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 
	 */
	private Long orgId;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private Integer studentNum;
	/**
	 * 是否全部毕业,班级是否结课
	 */
	private Integer isFinish;
	/**
	 * 班级结课时间
	 */
	private Date finishDate;
	/**
	 * 当前课程id
	 */
	private Long courseId;
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
	public void setStudentNum(Integer studentNum) {
		this.studentNum = studentNum;
	}
	/**
	 * 获取：
	 */
	public Integer getStudentNum() {
		return studentNum;
	}
	/**
	 * 设置：是否全部毕业,班级是否结课
	 */
	public void setIsFinish(Integer isFinish) {
		this.isFinish = isFinish;
	}
	/**
	 * 获取：是否全部毕业,班级是否结课
	 */
	public Integer getIsFinish() {
		return isFinish;
	}
	/**
	 * 设置：班级结课时间
	 */
	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}
	/**
	 * 获取：班级结课时间
	 */
	public Date getFinishDate() {
		return finishDate;
	}
	/**
	 * 设置：当前课程id
	 */
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	/**
	 * 获取：当前课程id
	 */
	public Long getCourseId() {
		return courseId;
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
