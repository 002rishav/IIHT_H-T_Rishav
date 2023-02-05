package com.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.user.controller.JwtController;
import com.user.entity.JwtRequest;
import com.user.utility.JwtService;

@ExtendWith(MockitoExtension.class)
public class JwtControllerTest {
	
	@InjectMocks
	private JwtController jwtController;
	
	@Mock
	private JwtService jwtService;
	
	@Mock
	private JwtRequest jwtRequest;
	
	@Test
	public void createJwtTokenTest() throws Exception {
		Mockito.lenient().when(jwtController.createJwtToken(jwtRequest)).thenReturn(null);
	}

}
