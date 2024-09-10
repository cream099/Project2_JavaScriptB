package com.it.rmu.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.it.rmu.entity.OrderEntity;
//import com.it.rmu.rmu.entity.UserEntity;






//@Repository
//public interface OrderRepository extends JpaRepository<OrderEntity, Integer>{
//	
//	@Query("select t from OrderEntity t where t.UserId = ?1")
//    public OrderEntity findByUserDetail(Integer UserId);
//
//	@Query("select t from UserEntity t where t.roleId = 1 ")
//    public List<UserEntity> findAllUser();
//	
//	@Modifying(clearAutomatically = true)
//	@Query("delete from OrderEntity t where t.id = ?1")
//	void deleteByOrderId(Integer ordersId);
//	
//	@Modifying
//	@Query("UPDATE OrderEntity o SET o.userId = :userId, o.address = :address, o.provinceId = :provinceId, o.amphureId = :amphureId, o.tambonId = :tambonId, o.zipcode = :zipcode, o.status = :status, o.updateBy = :updateBy, o.updateDate = :updateDate WHERE o.id = :id")
//	void updateOrderDetails(Integer userId, String address, Integer provinceId, Integer amphureId, Integer tambonId, Integer zipcode, String status, String updateBy, Date updateDate, Integer id);
//
//	 }
@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {

    @Query("select t from OrderEntity t where t.userId = ?1")
    public OrderEntity findByUserDetail(Integer userId);
    
    @Query("SELECT o FROM OrderEntity o WHERE o.userId = :userId")
    List<OrderEntity> findByUserId(@Param("userId") Integer userId);


//    @Query("select t from UserEntity t where t.roleId = 1")
//    public List<UserEntity> findAllUser();

    @Modifying
    @Query("delete from OrderEntity t where t.id = ?1")
    void deleteByOrderId(Integer orderId);

    @Modifying
    @Query("UPDATE OrderEntity o SET o.userId = :userId, o.name = :name, o.shippingAddress = :shippingAddress, o.phone = :phone, o.status = SUBSTRING(:status, 1, 255), o.updateBy = :updateBy, o.updateDate = :updateDate WHERE o.id = :id")
    void updateOrderDetails(Integer userId, String name, String shippingAddress, String phone, String status, String updateBy, Date updateDate, Integer id);
    
    @Modifying(clearAutomatically = true)
	@Query("delete from PaymentEntity t where t.id = ?1")
	void deleteByPaymentImgId(Integer paymentImgId);
}
