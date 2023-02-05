package com.user.controller;

import com.user.constraints.MerchantConstraint;
import com.user.entity.Merchant;
import com.user.service.impl.MerchantService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
@RestController
@RequiredArgsConstructor
@Validated
public class MerchantController {
    private final MerchantService merchantService;

    @PostMapping({"/api/v1/reg"})
    public Merchant registerNewMerchant(@MerchantConstraint @RequestBody Merchant merchant) {
        return merchantService.registerNewMerchant(merchant);
    }

}
