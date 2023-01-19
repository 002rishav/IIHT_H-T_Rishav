package com.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.user.controller.RoleController;
import com.user.entity.Role;
import com.user.service.impl.RoleService;

@ExtendWith(MockitoExtension.class)
public class RoleControllerTest {
	
	@InjectMocks
	private RoleController roleController;
	
	@Mock
	private Role role;
	
	@Mock
	private RoleService roleService;
	
	@Test
	public void createNewRoleTest() {
		Mockito.lenient().when(roleController.createNewRole(role)).thenReturn(null);
	}

}
