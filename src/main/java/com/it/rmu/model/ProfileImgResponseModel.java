package com.it.rmu.model;

public class ProfileImgResponseModel {
	private Integer profileImgId;
	private Integer userId;
	private String profileImgPath;
	private String profileImgName;
	private byte[] profileImgData;
	private String status;
	
	public Integer getProfileImgId() {
		return profileImgId;
	}
	public void setProfileImgId(Integer profileImgId) {
		this.profileImgId = profileImgId;
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
	
	
}
