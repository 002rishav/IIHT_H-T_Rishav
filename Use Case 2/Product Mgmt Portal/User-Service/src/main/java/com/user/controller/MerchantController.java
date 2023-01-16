package com.user.controller;

import com.user.entity.Merchant;
import com.user.service.impl.MerchantService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
@RestController
@RequiredArgsConstructor
public class MerchantController {
    private final MerchantService merchantService;

    @PostMapping({"/registerNewMerchant"})
    public Merchant registerNewMerchant(@RequestBody Merchant merchant) {
        return merchantService.registerNewMerchant(merchant);
    }

}
