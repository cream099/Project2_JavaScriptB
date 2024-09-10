package com.it.rmu.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "profile_img")
public class ProfileImgEntity {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "user_id")
	private Integer userId;
	
	@Column(name = "profile_img_path")
	private String profileImgPath;
	
	@Column(name = "profile_img_name")
	private String profileImgName;
	
	@Lob
    @Column(name = "profile_img_data")
    private byte[] profileImgData;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "create_by")
	private String createBy;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "create_date")
	private Date createDate;
	
	@Column(name = "update_by")
	private String updateBy;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "update_date")
	private Date updateDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getProfileImgPath() {
		return profileImgPath;
	}

	public void setProfileImgPath(String profileImgPath) {
		this.profileImgPath = profileImgPath;
	}

	public String getProfileImgName() {
		return profileImgName;
	}

	public void setProfileImgName(String profileImgName) {
		this.profileImgName = profileImgName;
	}

	public byte[] getProfileImgData() {
		return profileImgData;
	}

	public void setProfileImgData(byte[] profileImgData) {
		this.profileImgData = profileImgData;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	
	
	
}
