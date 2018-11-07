package com.apap.tutorial8.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.apap.tutorial8.model.UserRoleModel;

@Repository
public interface UserRoleDb extends JpaRepository<UserRoleModel, Long>{
	UserRoleModel findByUsername(String username);
}