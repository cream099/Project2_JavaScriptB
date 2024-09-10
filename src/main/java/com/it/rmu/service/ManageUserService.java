package com.it.rmu.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.DataFormatException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import com.it.rmu.entity.ProfileImgEntity;
import com.it.rmu.entity.UserDetailEntity;
import com.it.rmu.entity.UserEntity;
import com.it.rmu.model.ManageUserResponseModel;

import com.it.rmu.model.ProfileImgResponseModel;
import com.it.rmu.repository.ProfileImgRepository;
import com.it.rmu.repository.UserDetailRepository;
import com.it.rmu.repository.UserRepository;
import com.it.rmu.utils.Constants;
import com.it.rmu.utils.ImgUtils;

import jakarta.transaction.Transactional;

@Service
public class ManageUserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserDetailRepository userDetailRepository;
	
	@Autowired
	ProfileImgRepository profileImgRepository;
	
	public List<ManageUserResponseModel> getAllUser(){
		
		List<ManageUserResponseModel> response = null;
		
		List<UserEntity> userEntityList = userRepository.findAllUser();
		
		if(null != userEntityList) {
			
			response = new ArrayList<>();
			
			for(UserEntity user : userEntityList) {
				
				ManageUserResponseModel responseObject = new ManageUserResponseModel();
				
				responseObject.setUserId(user.getId());
				responseObject.setUserName(user.getUserName());
				responseObject.setPassword(user.getPassword());
				responseObject.setRoleId(user.getRoleId());
				responseObject.setStatus(user.getStatus());
				
				responseObject.setCreateDate(user.getCreateDate());
				
				UserDetailEntity userDetail = userDetailRepository.findByUserId(user.getId());
				
				if(null != userDetail) {
					responseObject.setFristName(userDetail.getFristName());
					responseObject.setLastName(userDetail.getLastName());
					responseObject.setPhone(userDetail.getPhone());
					responseObject.setAge(userDetail.getAge());
				}
				
				
				response.add(responseObject);
			}
		}
		
		
		return response;
	}
	
	
	@Transactional
	public Integer delete(Integer profileImgId) throws IOException {
		Integer response = null;
		if(null != profileImgId) {
			userRepository.deleteByProfileImgId(profileImgId);
			this.removeImgAndDeleteFileImgByProfileImgId(profileImgId);
			response = profileImgId;
		}
		return response;
	}
	
	public List<ProfileImgResponseModel> getProfileImgByUserId(Integer userId){
		List<ProfileImgResponseModel> response = null;
		
		List<ProfileImgEntity> profileImgList = profileImgRepository.findByProfileImgId(userId);
		
		if(null != profileImgList) {
			response = new ArrayList<>();
			for(ProfileImgEntity  profileImg : profileImgList) {
				ProfileImgResponseModel objectResponse = new ProfileImgResponseModel();
				objectResponse.setProfileImgId(profileImg.getId());
				objectResponse.setUserId(profileImg.getUserId());
				objectResponse.setProfileImgName(profileImg.getProfileImgName());
				objectResponse.setProfileImgPath(profileImg.getProfileImgPath());
				objectResponse.setProfileImgData(profileImg.getProfileImgData());
				objectResponse.setStatus(profileImg.getStatus());
				response.add(objectResponse);
			}
		}
		
		return response;
	}
	@Transactional
	public void removeImgAndDeleteFileImgByProfileImgId(Integer userId) throws IOException {
		List<ProfileImgEntity> profileImgList = profileImgRepository.findByProfileImgId(userId);
		profileImgRepository.deleteAll(profileImgList);
	}
	
	@Transactional
	public void deleteImgByFileName(String fileName) throws IOException {
		ProfileImgEntity profileImgList = profileImgRepository.findByProfileImgName(fileName);
		profileImgRepository.delete(profileImgList);
	}
	
	public byte[] getImageByte(String fileName) throws IOException, DataFormatException {
		ProfileImgEntity profileImg = profileImgRepository.findByProfileImgName(fileName);
		
		if(null != profileImg) {
			return ImgUtils.decompressImage(profileImg.getProfileImgData());
		}

        return null;
	}
	@Transactional
	public Integer saveImage(MultipartFile file, Integer userId) throws IOException {
		Integer response = null;
		if(null != file && null != userId) {
			ProfileImgEntity profileImg = new ProfileImgEntity();
			String preFixNameFile = ImgUtils.genaratePrefixFile();
			String genarateFileName = ImgUtils.genarateFileName() +ImgUtils.subStrFileName(file.getOriginalFilename());
			String fileName = ImgUtils.concatStr(preFixNameFile, genarateFileName);
			profileImg.setProfileImgName(fileName);
			profileImg.setProfileImgPath(ImgUtils.getPathInput());
			profileImg.setUserId(userId);
			profileImg.setProfileImgData(ImgUtils.compressImage(file.getBytes()));
			profileImg.setStatus("1");
			profileImg.setCreateBy("Joey");
			profileImg.setCreateDate(new Date());
			profileImg.setUpdateBy("Joey Update");
			profileImg.setUpdateDate(new Date());
			profileImg = profileImgRepository.save(profileImg);
			response = profileImg.getId();
			
//			ImgUtils.saveFile(file, fileName, Constants.PATH_TYPE_INPUT);
		}
		return response;
	}
	@Transactional
	public void deleteImgSever(String fileName) throws IOException {
		if(null != fileName) {
			ImgUtils.deleteFile(fileName, Constants.PATH_TYPE_INPUT);
		}
		
	}
		
}