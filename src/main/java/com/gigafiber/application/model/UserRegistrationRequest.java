package com.gigafiber.application.model;

import lombok.Data;

@Data
public class UserRegistrationRequest {

	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String email;
	private long phoneNo;

}
