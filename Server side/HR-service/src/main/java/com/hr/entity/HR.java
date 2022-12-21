package com.hr.entity;

import java.util.ArrayList;
import java.util.List;

public class HR {
	private Long userID;
	private String name;
	private String phone;
	
	private List<Resource> resource=new ArrayList<>();

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Resource> getResource() {
		return resource;
	}

	public void setResource(List<Resource> resource) {
		this.resource = resource;
	}

	public HR(Long userID, String name, String phone, List<Resource> resource) {
		super();
		this.userID = userID;
		this.name = name;
		this.phone = phone;
		this.resource = resource;
	}

	public HR(Long userID, String name, String phone) {
		super();
		this.userID = userID;
		this.name = name;
		this.phone = phone;
	}

	public HR() {
		super();
	}
	
	

}
