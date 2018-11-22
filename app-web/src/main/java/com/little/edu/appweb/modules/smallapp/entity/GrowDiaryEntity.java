package com.little.edu.appweb.modules.smallapp.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 成长日记日记表
 * 
 * @author huangqi
 * @email xxx@gmail.com
 * @date 2018-11-22 16:17:30
 */
@TableName("grow_diary")
public class GrowDiaryEntity implements Serializable {
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
	 * child表id
	 */
	private Long childId;
	/**
	 * student表id
	 */
	private Long studentId;
	/**
	 * course_libary表id
	 */
	private Long courseId;
	/**
	 * 
	 */
	private Long classId;
	/**
	 * 
	 */
	private String courseName;
	/**
	 * 0-成长中 1-已毕业
	 */
	private Integer status;
	/**
	 * 
	 */
	private Date finishDate;
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
	 * 设置：child表id
	 */
	public void setChildId(Long childId) {
		this.childId = childId;
	}
	/**
	 * 获取：child表id
	 */
	public Long getChildId() {
		return childId;
	}
	/**
	 * 设置：student表id
	 */
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	/**
	 * 获取：student表id
	 */
	public Long getStudentId() {
		return studentId;
	}
	/**
	 * 设置：course_libary表id
	 */
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	/**
	 * 获取：course_libary表id
	 */
	public Long getCourseId() {
		return courseId;
	}
	/**
	 * 设置：
	 */
	public void setClassId(Long classId) {
		this.classId = classId;
	}
	/**
	 * 获取：
	 */
	public Long getClassId() {
		return classId;
	}
	/**
	 * 设置：
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	/**
	 * 获取：
	 */
	public String getCourseName() {
		return courseName;
	}
	/**
	 * 设置：0-成长中 1-已毕业
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：0-成长中 1-已毕业
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：
	 */
	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}
	/**
	 * 获取：
	 */
	public Date getFinishDate() {
		return finishDate;
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
