package com.user;

import com.user.entity.Role;
import com.user.repository.RoleRepo;
import com.user.service.impl.RoleService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class RoleServiceTest {

    @InjectMocks
    RoleService roleService;

    @Mock
    RoleRepo roleRepo;

    @Mock
    Role role;

    @Test
    public void createNewRoleTest(){
        role = new Role();
        Mockito.lenient().when(roleRepo.save(any())).thenReturn(any());
        assertEquals(null,roleService.createNewRole(role));
    }
}
