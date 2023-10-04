package com.gigafiber.application.model;

import lombok.Data;

@Data
public class UserLoginRequest {

	private String userName;
	private String passWord;
	private String email;
	

}
