package com.it.rmu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.it.rmu.model.ImgUserRequestModel;
import com.it.rmu.model.ResponseModel;
import com.it.rmu.service.ImgUserSevice;

@RestController
@RequestMapping("/imguser")
public class ImgUserController {

	@Autowired
	private ImgUserSevice imguserService;

	@GetMapping("/getById")
	public ResponseModel getById(@RequestParam(name = "id") Integer id) {
		ResponseModel response = new ResponseModel();

		try {
			// service
			response.setData(imguserService.getById(id));
			response.setStatus("SUCCESS");
		} catch (Exception e) {
			// TODO: handle exception
			response.setStatus("ERROR");
			response.setMessage(e.getMessage());
		}

		return response;

	}

	@GetMapping("/getAll")
	public ResponseModel getAll() {
		ResponseModel response = new ResponseModel();

		try {
			// service
			response.setData(imguserService.getAll());
			response.setStatus("SUCCESS");
		} catch (Exception e) {
			// TODO: handle exception
			response.setStatus("ERROR");
			response.setMessage(e.getMessage());
		}

		return response;
	}

	@PostMapping("/save")
	public ResponseModel save(@ModelAttribute ImgUserRequestModel imguserRequest) {
		ResponseModel response = new ResponseModel();

		try {
			// service
			response.setData(imguserService.save(imguserRequest));
			response.setStatus("SUCCESS");
		} catch (Exception e) {
			// TODO: handle exception
			response.setStatus("ERROR");
			response.setMessage(e.getMessage());
		}

		return response;
	}

	@PutMapping(value = "/update/{id}", consumes = "multipart/form-data")
	public ResponseModel update(@ModelAttribute ImgUserRequestModel imguserRequest, @PathVariable Integer id) {
	    ResponseModel response = new ResponseModel();

	    try {
	        response.setData(imguserService.update(imguserRequest, id));
	        response.setStatus("SUCCESS");
	    } catch (Exception e) {
	        response.setStatus("ERROR");
	        response.setMessage(e.getMessage());
	    }

	    return response;
	}

	@DeleteMapping("/delete")
	public ResponseModel delete(@RequestParam(name = "id") Integer id) {

		ResponseModel response = new ResponseModel();

		try {
			response.setData(imguserService.delete(id));
			response.setStatus("SUCCESS");
		} catch (Exception e) {
			// TODO: handle exception
			response.setStatus("ERROR");
			response.setMessage(e.getMessage());
		}

		return response;
	}

}
