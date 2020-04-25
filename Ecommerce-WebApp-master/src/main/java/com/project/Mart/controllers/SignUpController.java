package com.project.Mart.controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Mart.controllers.RequestPojo.ApiResponse;
import com.project.Mart.models.User;
import com.project.Mart.services.UserService;

@RestController
@RequestMapping("/api/signup")
public class SignUpController {
	@Autowired
	  UserService userservice;
	@RequestMapping("/user")
	public ResponseEntity<?> userLogin(@RequestBody HashMap<String,String> signupRequest) {
		try {
			//TODO validation has to add for client request
			User user = userservice.signUpUser(signupRequest);
			return  ResponseEntity.ok(user);
		}catch(Exception e ) {
			return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
		}
	}
}