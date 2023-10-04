package com.gigafiber.application.service.impl;

import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gigafiber.application.entity.Role;
import com.gigafiber.application.entity.User;
import com.gigafiber.application.model.UserLoginRequest;
import com.gigafiber.application.model.UserRegistrationRequest;
import com.gigafiber.application.repository.UserRegistrationRepository;
import com.gigafiber.application.repository.UserRoleRepository;
import com.gigafiber.application.response.UserRegistrationResponse;
import com.gigafiber.application.service.UserRegistrationService;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {

	@Autowired
	UserRegistrationRepository userRegistrationRepository;

	@Autowired
	UserRoleRepository userRoleRepository;

	// @Autowired
	// private PasswordEncoder passwordEncoder;

	Logger logger = LoggerFactory.getLogger(UserRegistrationServiceImpl.class);

	@Override
	public ResponseEntity<UserRegistrationResponse> signUp(UserRegistrationRequest userRegistrationRequest) {
		UserRegistrationResponse userRegistrationResponse = new UserRegistrationResponse();
		if (userRegistrationRequest != null) {

			if (userRegistrationRepository.existsByUserName(userRegistrationRequest.getUserName())) {

				userRegistrationResponse.setStatusCode("400");
				userRegistrationResponse
						.setStatusDescription("There is already an account registered with the same username!");
			}
			if (userRegistrationRepository.existsByEmail(userRegistrationRequest.getEmail())) {

				userRegistrationResponse.setStatusCode("400");
				userRegistrationResponse
						.setStatusDescription("There is already an account registered with the same email!");

			}

			User user = new User();
			user.setFirstName(userRegistrationRequest.getFirstName());
			user.setLastName(userRegistrationRequest.getLastName());
			user.setUserName(userRegistrationRequest.getUserName());
			user.setEmail(userRegistrationRequest.getEmail());
			user.setPassword(userRegistrationRequest.getPassword());
			user.setPhoneNo(userRegistrationRequest.getPhoneNo());

			Role roles = userRoleRepository.findByName("ROLE_ADMIN");
			if (roles != null) {
				user.setRoles(Collections.singleton(roles));
			} else {
				user.setRoles(user.getRoles());
			}

			try {

				userRegistrationRepository.save(user);
				userRegistrationResponse.setStatusCode("200");
				userRegistrationResponse.setStatusDescription("User Registered successfully");

			} catch (Exception e) {
				logger.error("user is not able to save please check once....");
				userRegistrationResponse.setStatusCode("400");
				userRegistrationResponse.setStatusDescription("User Not able to registered getting an exception!");

			}
		}

		return new ResponseEntity<>(userRegistrationResponse, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<UserRegistrationResponse> signIn(UserLoginRequest userLoginRequest) {
		UserRegistrationResponse userRegistrationResponse = new UserRegistrationResponse();
		if (userLoginRequest != null) {
			if (userRegistrationRepository.findByUserName(userLoginRequest.getUserName())
					|| userRegistrationRepository.findByEmail(userLoginRequest.getEmail())) {

				userRegistrationResponse.setStatusCode("200");
				userRegistrationResponse.setStatusDescription("User Login successfully");

			} else {
				userRegistrationResponse.setStatusCode("400");
				userRegistrationResponse.setStatusDescription("User Not able to Found");
			}

		}
		return new ResponseEntity<>(userRegistrationResponse, HttpStatus.OK);

	}
}
