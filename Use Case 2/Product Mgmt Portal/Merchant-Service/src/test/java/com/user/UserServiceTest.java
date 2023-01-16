//package com.user;
//
//import com.user.entity.Role;
//import com.user.entity.Merchant;
//import com.user.repository.RoleRepo;
//import com.user.repository.MerchantRepo;
//import com.user.service.impl.MerchantService;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import java.util.Optional;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@ExtendWith(MockitoExtension.class)
//public class UserServiceTest {
//
//    @InjectMocks
//    MerchantService userService;
//
//    @Mock
//    MerchantRepo userRepo;
//
//    @Mock
//    RoleRepo roleRepo;
//
//    @Mock
//    Merchant user;
//
//    @Mock
//    Role role;
//
//    @Mock
//    PasswordEncoder passwordEncoder;
//
//    @Test
//    public void createNewUserTest(){
//        user = new Merchant();
//        role = new Role();
//        Mockito.lenient().when(roleRepo.save(role)).thenReturn(role);
//        Mockito.lenient().when(userRepo.save(user)).thenReturn(user);
//        Mockito.when(roleRepo.findById("User")).thenReturn(Optional.of(role));
//        userService.registerNewUser(user);
//    }
//
//    @Test
//    public void createNewAdminTest(){
//        user = new Merchant();
//        role = new Role();
//        Mockito.lenient().when(roleRepo.save(role)).thenReturn(role);
//        Mockito.lenient().when(userRepo.save(user)).thenReturn(user);
//        Mockito.when(roleRepo.findById("Admin")).thenReturn(Optional.of(role));
//        userService.registerNewAdmin(user);
//    }
//
//    @Test
//    public void getEncodedPasswordTest(){
//        String password = "pass";
//        assertEquals(null,userService.getEncodedPassword(password));
//    }
//}
