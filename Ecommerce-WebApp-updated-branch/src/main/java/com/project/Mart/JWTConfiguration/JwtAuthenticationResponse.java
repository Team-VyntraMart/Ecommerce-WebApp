package com.project.Mart.JWTConfiguration;

import java.util.List;

public class JwtAuthenticationResponse {
    private String accessToken;
    private String tokenType = "Bearer";
    private Long id;
    private String name;
    private String username;
    private String email;
    private List<String> roles;

	public JwtAuthenticationResponse(String accessToken, Long id, String name, String username, String email,
			List<String> roles) {
		super();
		this.accessToken = accessToken;
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getRoles() {
		return roles;
	}

	public JwtAuthenticationResponse(String accessToken) {
        this.accessToken = accessToken;
    }
    
    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }
}