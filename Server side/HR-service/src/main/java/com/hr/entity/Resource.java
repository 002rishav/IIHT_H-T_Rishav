package com.hr.entity;

public class Resource {
	
	private Long rID;
	private String email;
	private String resourceName;
	private String domain;
	
	private Long userID;

	public Resource(Long rID, String email, String resourceName, String domain, Long userID) {
		super();
		this.rID = rID;
		this.email = email;
		this.resourceName = resourceName;
		this.domain = domain;
		this.userID = userID;
	}

	public Resource() {
		super();
	}

	public Long getrID() {
		return rID;
	}

	public void setrID(Long rID) {
		this.rID = rID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}
	
	

}
