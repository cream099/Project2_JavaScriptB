package com.it.rmu.controller;

import java.io.IOException;
import java.util.zip.DataFormatException;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.it.rmu.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	

	@GetMapping("/getPaymentImgByOrdersId")
	public ResponseModel getPaymentImgByOrdersId(@RequestParam(name = "ordersId") Integer ordersId) {
		ResponseModel response = new ResponseModel();
		
		try {
			// service
			response.setData(paymentService.getPaymentImgByOrdersId(ordersId));
			response.setStatus("SUCCESS");
		} catch (Exception e) {
			// TODO: handle exception
			response.setStatus("ERROR");
			response.setMessage(e.getMessage());
		}

		return response;
	}
	
	@DeleteMapping("/delete")
	public ResponseModel delete(@RequestParam(name = "paymentImgId") Integer paymentImgId) {
		
		ResponseModel response = new ResponseModel();
		
		try {
			response.setData(paymentService.delete(paymentImgId));
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

		return ResponseEntity.ok(paymentService.getImageByte(fileName));
	}
	
	@PostMapping(value =("/saveImage/{ordersId}") , consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseModel saveImage(@RequestParam("file") MultipartFile file, @PathVariable Integer ordersId) {
		
		ResponseModel response = new ResponseModel();
		
		try {
			response.setData(paymentService.saveImage(file, ordersId));
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
			paymentService.deleteImgByFileName(fileName);
			response.setData("SUCCESS");
			response.setStatus("SUCCESS");
		} catch (Exception e) {
			// TODO: handle exception
			response.setStatus("ERROR");
			response.setMessage(e.getMessage());
		}
		
		return response;
	}
	
	@GetMapping("/getAllPayments")
    public ResponseModel getAllPayments() {
        ResponseModel response = new ResponseModel();
        
        try {
            response.setData(paymentService.getAllPayments());
            response.setStatus("SUCCESS");
        } catch (Exception e) {
            response.setStatus("ERROR");
            response.setMessage(e.getMessage());
        }
        
        return response;
    }

}