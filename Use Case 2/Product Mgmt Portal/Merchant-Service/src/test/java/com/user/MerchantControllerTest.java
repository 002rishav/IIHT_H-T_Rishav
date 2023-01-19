package com.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.user.controller.MerchantController;
import com.user.entity.Merchant;
import com.user.service.impl.MerchantService;

@ExtendWith(MockitoExtension.class)
public class MerchantControllerTest {

	@InjectMocks
	private MerchantController merchantController;
	
	@Mock
	private MerchantService merchantService;
	
	@Mock
	private Merchant merchant;
	
	@Test
	public void registerNewMerchantTest() {
		Mockito.lenient().when(merchantController.registerNewMerchant(merchant)).thenReturn(null);
	}
}
