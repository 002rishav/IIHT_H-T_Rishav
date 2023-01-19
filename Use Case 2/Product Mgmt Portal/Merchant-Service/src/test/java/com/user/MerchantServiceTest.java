package com.user;

import com.user.entity.Role;
import com.user.entity.Merchant;
import com.user.repository.RoleRepo;
import com.user.repository.MerchantRepo;
import com.user.service.impl.MerchantService;
import com.user.utility.SequenceGenerator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class MerchantServiceTest {

    @InjectMocks
    MerchantService userService;

    @Mock
    MerchantRepo merchantRepo;

    @Mock
    RoleRepo roleRepo;

    @Mock
    Merchant merchant;

    @Mock
    Role role;

    @Mock
    PasswordEncoder passwordEncoder;
    
    @Mock
    private SequenceGenerator sequenceGenerator;

    @Test
    public void registerNewMerchantTest(){
    	MockitoAnnotations.openMocks(this);
    	merchant = new Merchant();
        role = new Role();
        Mockito.lenient().when(roleRepo.save(role)).thenReturn(role);
        Mockito.lenient().when(merchantRepo.save(merchant)).thenReturn(merchant);
        Mockito.when(roleRepo.findById("Merchant")).thenReturn(Optional.of(role));
        Mockito.doReturn(1).when(sequenceGenerator).getSequenceNumber(any());
        userService.registerNewMerchant(merchant);
    }

    @Test
    public void getEncodedPasswordTest(){
        String password = "pass";
        assertEquals(null,userService.getEncodedPassword(password));
    }
}
