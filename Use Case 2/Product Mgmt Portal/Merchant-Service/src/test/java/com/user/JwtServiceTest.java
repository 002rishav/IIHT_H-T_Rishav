package com.user;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.user.service.impl.JwtService;

@ExtendWith(MockitoExtension.class)
public class JwtServiceTest {

	@InjectMocks
	private JwtService jwtService;
	
	
}
