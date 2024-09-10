package com.it.rmu.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.rmu.entity.ImgUserEntity;
import com.it.rmu.model.ImgUserRequestModel;
import com.it.rmu.model.ImgUserResponseModel;
import com.it.rmu.repository.ImgUserRepository;

import jakarta.transaction.Transactional;

@Service
public class ImgUserSevice {

	@Autowired
	private ImgUserRepository imguserRepository;
	
	public ImgUserResponseModel getById(Integer id) {

		ImgUserResponseModel response = null;
		 
		 Optional< ImgUserEntity> entity =   imguserRepository.findByUserId(id);
		 
		 if(entity.isPresent()) {
			 ImgUserEntity imguser = entity.get();
				response = new ImgUserResponseModel();
				response.setId(imguser.getId());
				response.setImg(imguser.getImg());
				response.setUserId(imguser.getUserId());
			}
		 
		 
			return response;
	}
	
public List<ImgUserResponseModel> getAll() {
		
		List<ImgUserResponseModel> response = null;
		
		List<ImgUserEntity> entitys = imguserRepository.findAll();
		
		if(null != entitys) {
			response = new ArrayList<>();
			for(ImgUserEntity imguser : entitys) {
				
				ImgUserResponseModel object = new ImgUserResponseModel();
				
				object.setId(imguser.getId());
				object.setImg(imguser.getImg());
				object.setUserId(imguser.getUserId());
				
				response.add(object);
			}

		}
		return response;
		
}
@Transactional
public Integer save(ImgUserRequestModel imguserRequest) throws IOException {
	
	Integer response = null;
	
	if(null != imguserRequest) {
		ImgUserEntity imguserEntity = new ImgUserEntity();
		
		if(imguserRequest.getImg() != null) {
			imguserEntity.setImg(Base64.getEncoder().encodeToString(imguserRequest.getImg().getBytes()));
		}
		
		imguserEntity.setUserId(imguserRequest.getUserId());
	
		
		imguserEntity = imguserRepository.save(imguserEntity);
		response = imguserEntity.getId();
		
	}
	return response;
	
}
@Transactional
public Integer update(ImgUserRequestModel imguserRequest, Integer id) throws IOException {
    Integer response = null;

    Optional<ImgUserEntity> imguserEntity = imguserRepository.findById(id);
    if (imguserEntity.isPresent()) {
        ImgUserEntity imguser = imguserEntity.get();
        imguser.setId(null != imguserRequest.getId() ? imguserRequest.getId() : imguser.getId());
        if (imguserRequest.getImg() != null) {
            imguser.setImg(Base64.getEncoder().encodeToString(imguserRequest.getImg().getBytes()));
        }
        imguser.setUserId(null != imguserRequest.getUserId() ? imguserRequest.getUserId() : imguser.getUserId());

        imguser = imguserRepository.save(imguser);
        response = imguser.getId();
    }

    return response;
}

@Transactional
public Integer delete(Integer id) throws IOException {
	Integer response = null;
	if(null != id) {
		imguserRepository.deleteById(id);
		response = id;
	}
	return response;
}


}
