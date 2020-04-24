package com.project.Mart.services.UserServices;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.project.Mart.models.UserModel;

@Service
public interface UserService {
	UserModel findByMobile(String mobile) throws Exception;
	UserModel getUserDetailById(long userId) throws Exception;
	UserModel signUpUser(HashMap<String,String> signupRequest) throws Exception;
	
}
