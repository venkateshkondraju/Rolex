package com.gigafiber.application.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gigafiber.application.entity.User;

@Repository
public interface UserRegistrationRepository extends MongoRepository<User, Long> {

	Boolean existsByUserName(String userName);

	boolean existsByEmail(String email);
	
	Boolean findByUserName(String userName);
	
	boolean findByEmail(String email);

}
