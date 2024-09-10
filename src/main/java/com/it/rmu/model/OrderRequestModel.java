package com.it.rmu.model;

public class OrderRequestModel {

	private Integer ordersId;
	private Integer userId;
	private Integer productId[];
	private String name;
	private String shippingAddress;
	private String phone;
	private Integer quantity[];
	private String status;
	public Integer getOrdersId() {
		return ordersId;
	}
	public void setOrdersId(Integer ordersId) {
		this.ordersId = ordersId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer[] getProductId() {
		return productId;
	}
	public void setProductId(Integer[] productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer[] getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer[] quantity) {
		this.quantity = quantity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
