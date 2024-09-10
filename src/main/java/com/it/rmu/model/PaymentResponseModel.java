package com.it.rmu.model;


public class PaymentResponseModel {

	private Integer paymentImgId;
	private Integer ordersId;
	private String paymentImgPath;
	private String paymentImgName;
	private byte[] paymentImgData;
	private String status;
	
	public Integer getPaymentImgId() {
		return paymentImgId;
	}
	public void setPaymentImgId(Integer paymentImgId) {
		this.paymentImgId = paymentImgId;
	}
	public Integer getOrdersId() {
		return ordersId;
	}
	public void setOrdersId(Integer ordersId) {
		this.ordersId = ordersId;
	}
	public String getPaymentImgPath() {
		return paymentImgPath;
	}
	public void setPaymentImgPath(String paymentImgPath) {
		this.paymentImgPath = paymentImgPath;
	}
	public String getPaymentImgName() {
		return paymentImgName;
	}
	public void setPaymentImgName(String paymentImgName) {
		this.paymentImgName = paymentImgName;
	}
	public byte[] getPaymentImgData() {
		return paymentImgData;
	}
	public void setPaymentImgData(byte[] paymentImgData) {
		this.paymentImgData = paymentImgData;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
