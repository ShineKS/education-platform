package com.little.edu.appweb.modules.smallapp.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 附件资源关系表
 * 
 * @author huangqi
 * @email xxx@gmail.com
 * @date 2018-11-22 16:17:30
 */
@TableName("attach_relation")
public class AttachRelationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 数据id
	 */
	private Long dataId;
	/**
	 * 附件表id
	 */
	private Long attachmentId;
	/**
	 * 1-学生资料 2-成长之路 3-家长评价
	 */
	private Integer dataType;

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
	 * 设置：数据id
	 */
	public void setDataId(Long dataId) {
		this.dataId = dataId;
	}
	/**
	 * 获取：数据id
	 */
	public Long getDataId() {
		return dataId;
	}
	/**
	 * 设置：附件表id
	 */
	public void setAttachmentId(Long attachmentId) {
		this.attachmentId = attachmentId;
	}
	/**
	 * 获取：附件表id
	 */
	public Long getAttachmentId() {
		return attachmentId;
	}
	/**
	 * 设置：1-学生资料 2-成长之路 3-家长评价
	 */
	public void setDataType(Integer dataType) {
		this.dataType = dataType;
	}
	/**
	 * 获取：1-学生资料 2-成长之路 3-家长评价
	 */
	public Integer getDataType() {
		return dataType;
	}
}
