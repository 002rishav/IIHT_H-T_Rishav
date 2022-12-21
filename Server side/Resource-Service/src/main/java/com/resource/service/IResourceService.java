package com.resource.service;

import java.util.List;

import com.resource.entity.Resource;

public interface IResourceService {
	
	public List<Resource> getResourceForUsers(Long userID);

}
