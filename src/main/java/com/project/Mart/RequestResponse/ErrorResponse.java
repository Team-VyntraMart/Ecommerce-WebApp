package com.project.Mart.RequestResponse;

public class ErrorResponse {
    private int code;
    private String message;
	public int getCode() {
		return code;
	}
	public String getMessage() {
		return message;
	}
	public ErrorResponse(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
}
