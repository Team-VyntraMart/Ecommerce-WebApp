package com.project.Mart.services.UserServices.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Mart.repositories.UserRepository;
import com.project.Mart.models.UserModel;
import com.project.Mart.services.UserServices.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;
	
	@Override
	public UserModel findByMobile(String mobile) throws Exception {
		return userRepo.findByMobile(mobile).orElseThrow(()->new Exception("User Not found.."));
	}

	@Override
	public UserModel getUserDetailById(long userId) throws Exception {
		
		return userRepo.findById(userId).orElseThrow(()->new Exception("User Not found.."));
	}

	@Override
	public UserModel signUpUser(HashMap<String, String> signupRequest) throws Exception {
		try {
			if(userRepo.findByMobile(signupRequest.get("mobile")).isPresent()) {
				throw new Exception("User is already registered with Mobile No.");
			}
			UserModel user = new UserModel();
			user.setName(signupRequest.get("name"));
			user.setEmail(signupRequest.get("email"));
			user.setMobile(signupRequest.get("mobile"));
			user.setPassword(signupRequest.get("password"));
			userRepo.save(user);
			return user;
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}
}
