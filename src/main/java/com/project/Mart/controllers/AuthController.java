package com.project.Mart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.Mart.JWTConfiguration.JwtAuthenticationResponse;
import com.project.Mart.RequestResponse.ApiResponse;
import com.project.Mart.RequestResponse.LoginRequest;
import com.project.Mart.RequestResponse.SignUpRequest;
import com.project.Mart.services.AuthService;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api")
public class AuthController {

    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    
    @RequestMapping("/status")//post and get
  	public ResponseEntity<?> serverStatus() {
    	  return new ResponseEntity<>(new ApiResponse("Server is running.", ""), HttpStatus.OK);
   }
    
    @PostMapping("/login/user")
    @ResponseStatus(OK)
    public JwtAuthenticationResponse login(@Valid @RequestBody LoginRequest loginRequest) {
        return authService.authenticateUser(loginRequest);
    }

    @PostMapping("/signup/user")
    @ResponseStatus(OK)
    public Long register(@Valid @RequestBody SignUpRequest signUpRequest) {
        return authService.registerUser(signUpRequest);
    }
}
