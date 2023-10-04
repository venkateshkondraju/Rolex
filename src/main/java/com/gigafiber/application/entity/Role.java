package com.gigafiber.application.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.gigafiber.application.enums.ERole;

import lombok.Data;

@Document(collection = "roles")
@Data
public class Role {
	@Id
	private String id;

	private ERole name;

}
