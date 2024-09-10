package com.it.rmu.controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.it.rmu.model.ResponseModel;
import com.it.rmu.service.GenExcelService;
import com.it.rmu.service.GenPdfService;
import com.it.rmu.service.ManageUserService;
import com.it.rmu.utils.Constants;

@RestController
@RequestMapping("/manage/user")
public class ManageUserController {

	@Autowired
	private ManageUserService manageUserService;
	
	@Autowired
	private GenPdfService genPdfService;
	
	@Autowired
	private GenExcelService genExcelService;
	
	@GetMapping("/getAllUser")
	public ResponseModel getAllUser() {
		ResponseModel response = new ResponseModel();
		
		try {
			// service
			response.setData(manageUserService.getAllUser());
			response.setStatus("SUCCESS");
		} catch (Exception e) {
			// TODO: handle exception
			response.setStatus("ERROR");
			response.setMessage(e.getMessage());
		}

		return response;
	}
	
	@GetMapping("/download/pdf")
	public ResponseEntity<?> downloadPdf() throws IOException {

		File file = genPdfService.genPDF(manageUserService.getAllUser(), Constants.TYPE_CUSTOMER);
	    InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

	    HttpHeaders headers = new HttpHeaders(); headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=user-data.pdf");
	    
	    return ResponseEntity.ok()
	            .headers(headers)
	            .contentLength(file.length())
	            .contentType(MediaType.APPLICATION_OCTET_STREAM)
	            .body(resource);
	}
	
	@GetMapping("/download/excel")
	public ResponseEntity<?> download() throws IOException {

		File file = genExcelService.genExcel(manageUserService.getAllUser(), Constants.TYPE_CUSTOMER);
	    InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

	    HttpHeaders headers = new HttpHeaders(); headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=user-data.xlsx");
	    
	    return ResponseEntity.ok()
	            .headers(headers)
	            .contentLength(file.length())
	            .contentType(MediaType.APPLICATION_OCTET_STREAM)
	            .body(resource);
	}
	
	@GetMapping("/getProfileImgByUserId")
	public ResponseModel getProfileImgByUserId(@RequestParam(name = "userId") Integer userId) {
		ResponseModel response = new ResponseModel();
		
		try {
			// service
			response.setData(manageUserService.getProfileImgByUserId(userId));
			response.setStatus("SUCCESS");
		} catch (Exception e) {
			// TODO: handle exception
			response.setStatus("ERROR");
			response.setMessage(e.getMessage());
		}

		return response;
	}
	
	@DeleteMapping("/delete")
	public ResponseModel delete(@RequestParam(name = "profileImgId") Integer profileImgId) {
		
		ResponseModel response = new ResponseModel();
		
		try {
			response.setData(manageUserService.delete(profileImgId));
			response.setStatus("SUCCESS");
		} catch (Exception e) {
			// TODO: handle exception
			response.setStatus("ERROR");
			response.setMessage(e.getMessage());
		}
		
		return response;
	}
	
	@GetMapping("/getImageByte")
	public ResponseEntity<byte[]> getImageByte(@RequestParam(name = "fileName") String fileName) throws IOException, DataFormatException {

		return ResponseEntity.ok(manageUserService.getImageByte(fileName));
	}
	
	@PostMapping(value =("/saveImage/{userId}") , consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseModel saveImage(@RequestParam("file") MultipartFile file, @PathVariable Integer userId) {
		
		ResponseModel response = new ResponseModel();
		
		try {
			response.setData(manageUserService.saveImage(file, userId));
			response.setStatus("SUCCESS");
		} catch (Exception e) {
			// TODO: handle exception
			response.setStatus("ERROR");
			response.setMessage(e.getMessage());
		}
		
		return response;
	}
	
	@DeleteMapping(value =("/deleteImgByFileName"))
	public ResponseModel deleteImgByFileName(@RequestParam(name = "fileName") String fileName) {
		
		ResponseModel response = new ResponseModel();
		
		try {
			manageUserService.deleteImgByFileName(fileName);
			response.setData("SUCCESS");
			response.setStatus("SUCCESS");
		} catch (Exception e) {
			// TODO: handle exception
			response.setStatus("ERROR");
			response.setMessage(e.getMessage());
		}
		
		return response;
	}

}