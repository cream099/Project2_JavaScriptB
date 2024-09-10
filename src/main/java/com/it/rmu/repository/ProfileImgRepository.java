package com.it.rmu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.it.rmu.entity.ProfileImgEntity;
@Repository
public interface ProfileImgRepository extends JpaRepository<ProfileImgEntity, Integer>{
	
	@Query("select t from ProfileImgEntity t where t.userId = ?1")
	public List<ProfileImgEntity> findByProfileImgId(Integer userId);
	
	@Modifying(clearAutomatically = true)
	@Query("delete from ProfileImgEntity t where t.userId = ?1")
	void deleteByProfileImgId(Integer userId);
	
	@Query("select t from ProfileImgEntity t where t.profileImgName = ?1")
	public ProfileImgEntity findByProfileImgName(String profileImgName);
}