package com.project.Mart.services;

import java.util.HashMap;
import org.springframework.stereotype.Service;
import com.project.Mart.models.User;

@Service
public interface UserService {
	User findByMobile(String mobile) throws Exception;
	User getUserDetailById(long userId) throws Exception;
	User signUpUser(HashMap<String,String> signupRequest) throws Exception;
	
}
