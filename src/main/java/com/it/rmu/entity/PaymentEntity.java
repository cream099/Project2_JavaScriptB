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
@Table(name = "payment")
public class PaymentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "orders_id")
	private Integer ordersId;
	
	@Column(name = "payment_img_path")
	private String paymentImgPath;
	
	@Column(name = "payment_img_name")
	private String paymentImgName;
	
	@Lob
    @Column(name = "payment_img_data")
    private byte[] paymentImgData;
	
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
