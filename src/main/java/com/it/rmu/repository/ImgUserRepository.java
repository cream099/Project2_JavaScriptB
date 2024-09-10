package com.it.rmu.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.it.rmu.entity.ImgUserEntity;

@Repository
public interface ImgUserRepository extends JpaRepository<ImgUserEntity, Integer>{

	 public    Optional<ImgUserEntity> findByUserId(Integer userId);
	}