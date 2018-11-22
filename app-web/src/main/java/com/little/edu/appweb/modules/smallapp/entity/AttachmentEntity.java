package com.little.edu.appweb.modules.smallapp.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 附件表
 * 
 * @author huangqi
 * @email xxx@gmail.com
 * @date 2018-11-22 16:17:30
 */
@TableName("attachment")
public class AttachmentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 文件名称
	 */
	private String name;
	/**
	 * 
	 */
	private Long size;
	/**
	 * 文件地址
	 */
	private String location;
	/**
	 * 文件类型 1-图片 2-视频
	 */
	private Integer fileType;
	/**
	 * 公司id
	 */
	private Long orgId;
	/**
	 * 
	 */
	private Date createDate;
	/**
	 * 0-未删除 1-已删除
	 */
	private Integer isDelete;

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
	 * 设置：文件名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：文件名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：
	 */
	public void setSize(Long size) {
		this.size = size;
	}
	/**
	 * 获取：
	 */
	public Long getSize() {
		return size;
	}
	/**
	 * 设置：文件地址
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * 获取：文件地址
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * 设置：文件类型 1-图片 2-视频
	 */
	public void setFileType(Integer fileType) {
		this.fileType = fileType;
	}
	/**
	 * 获取：文件类型 1-图片 2-视频
	 */
	public Integer getFileType() {
		return fileType;
	}
	/**
	 * 设置：公司id
	 */
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
	/**
	 * 获取：公司id
	 */
	public Long getOrgId() {
		return orgId;
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
	 * 设置：0-未删除 1-已删除
	 */
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	/**
	 * 获取：0-未删除 1-已删除
	 */
	public Integer getIsDelete() {
		return isDelete;
	}
}
