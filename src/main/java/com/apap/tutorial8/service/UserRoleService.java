package com.apap.tutorial8.service;

import com.apap.tutorial8.model.UserRoleModel;

public interface UserRoleService {
	UserRoleModel addUser(UserRoleModel user);
	String encrypt(String password);
	UserRoleModel getUserByUsername(String username);
	boolean isMatch(String rawPassword, String encodedPassword);
}