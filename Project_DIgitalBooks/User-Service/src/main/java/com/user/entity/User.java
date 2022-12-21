package com.user.entity;

import javax.persistence.Entity;

@Entity
public class User {
	
	private Integer userID;
	private String username;
	private String password;
	private String email;
	private String subscriptionID;

}
