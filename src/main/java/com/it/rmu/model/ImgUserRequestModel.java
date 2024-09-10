package com.it.rmu.model;

import org.springframework.web.multipart.MultipartFile;

public class ImgUserRequestModel {

	private Integer id;
    private MultipartFile Img;
    private Integer userId;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public MultipartFile getImg() {
		return Img;
	}
	public void setImg(MultipartFile img) {
		Img = img;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
    
}
