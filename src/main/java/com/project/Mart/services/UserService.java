package com.project.Mart.services;

import org.springframework.stereotype.Service;

import com.project.Mart.JWTConfiguration.UserPrincipal;
import com.project.Mart.RequestResponse.UserSummary;

@Service
public class UserService {

    public UserSummary getCurrentUser(UserPrincipal userPrincipal) {
        return UserSummary.builder()
                .id(userPrincipal.getId())
                .email(userPrincipal.getEmail())
                .name(userPrincipal.getName())
                .build();
    }
}