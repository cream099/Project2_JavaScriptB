package com.it.rmu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.it.rmu.entity.PaymentEntity;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity, Integer> {

	@Query("select t from PaymentEntity t where t.ordersId = ?1")
	public List<PaymentEntity> findByPaymentImgId(Integer ordersId);
	
	@Modifying(clearAutomatically = true)
	@Query("delete from PaymentEntity t where t.ordersId = ?1")
	void deleteByPaymentImgId(Integer ordersId);
	
	@Query("select t from PaymentEntity t where t.paymentImgName = ?1")
	public PaymentEntity findByPaymentImgName(String paymentImgName);
}
