package com.gigafiber.application.service;

import org.springframework.http.ResponseEntity;

import com.gigafiber.application.model.UserLoginRequest;
import com.gigafiber.application.model.UserRegistrationRequest;
import com.gigafiber.application.response.UserRegistrationResponse;

public interface UserRegistrationService {

	public ResponseEntity<UserRegistrationResponse> signUp(UserRegistrationRequest userRegistrationRequest);

	public ResponseEntity<UserRegistrationResponse> signIn(UserLoginRequest userLoginRequest);

}
