package com.gigafiber.application.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gigafiber.application.entity.Role;

public interface UserRoleRepository extends MongoRepository<Role, String> {

	Role findByName(String string);

}
