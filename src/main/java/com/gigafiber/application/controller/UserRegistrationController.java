package com.gigafiber.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gigafiber.application.model.UserLoginRequest;
import com.gigafiber.application.model.UserRegistrationRequest;
import com.gigafiber.application.response.UserRegistrationResponse;
import com.gigafiber.application.service.UserRegistrationService;

@RestController
@RequestMapping(value = "/user")
public class UserRegistrationController {

	@Autowired
	UserRegistrationService userRegistrationService;

	@PostMapping(value = "/signUp")
	public ResponseEntity<UserRegistrationResponse> signUp(@RequestBody UserRegistrationRequest userRegistrationRequest) {
		ResponseEntity<UserRegistrationResponse> response = userRegistrationService.signUp(userRegistrationRequest);
		return response;
	}

	@PostMapping(value = "/signIn")
	public ResponseEntity<UserRegistrationResponse> signIn(@RequestBody UserLoginRequest userLoginRequest) {
		ResponseEntity<UserRegistrationResponse> response = userRegistrationService.signIn(userLoginRequest);
		return response;
	}
}
