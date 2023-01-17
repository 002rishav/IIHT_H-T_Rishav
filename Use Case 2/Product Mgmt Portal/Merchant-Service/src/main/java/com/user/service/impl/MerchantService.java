package com.user.service.impl;

import com.user.repository.RoleRepo;
import com.user.repository.MerchantRepo;
import com.user.entity.Role;
import com.user.entity.Merchant;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class MerchantService {

    @Autowired
    private MerchantRepo merchantRepo;

    @Autowired
    private RoleRepo roleRepo;
    
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Merchant registerNewMerchant(Merchant merchant) {
        Role role= roleRepo.findById("Merchant").get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        merchant.setRole(userRoles);
        merchant.setUserPassword(getEncodedPassword(merchant.getUserPassword()));

        merchant.setId(sequenceGeneratorService.getSequenceNumber(Merchant.SEQUENCE_NAME));
        return merchantRepo.save(merchant);
    }

    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }
}
