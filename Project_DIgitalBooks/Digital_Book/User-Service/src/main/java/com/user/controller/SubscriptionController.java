package com.user.controller;

import com.user.service.SubscriptionService;
import com.user.utility.JwtUtility;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.concurrent.atomic.AtomicReference;

import static java.util.Optional.ofNullable;

@RestController
@RequiredArgsConstructor
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    private final JwtUtility jwtUtility;

    @PostMapping("/api/v1/digitalbooks/{book-id}/subscribe")
    @PreAuthorize("hasRole('User')")
    public ResponseEntity createSubscription(@PathVariable("book-id") String bookId,Principal principal){
        AtomicReference<String> userName = new AtomicReference<>("");
                ofNullable(principal).map(Principal::getName)
                .ifPresent(userName::set);
                return subscriptionService.saveSubscriptionDetails(bookId,userName.get());
    }

    @PostMapping("/api/v1/digitalbooks/readers/{user-name}/books/{book-id}/cancel-subscription")
    @PreAuthorize("hasRole('User')")
    public ResponseEntity cancelSubscription(@PathVariable("book-id") String bookId,@PathVariable("user-name") String userName){
        return subscriptionService.cancelSubscription(bookId,userName);
    }

    @GetMapping("/api/v1/digitalbooks/readers/{user-name}/books")
    @PreAuthorize("hasRole('User')")
    public ResponseEntity getAllSubscriptions(@PathVariable("user-name") String userName) {
        return subscriptionService.getAllSubscriptions(userName);
    }

    @GetMapping("/api/v1/digitalbooks/readers/{user-name}/books/{book-id}")
    @PreAuthorize("hasRole('User')")
    public ResponseEntity getSubscription(@PathVariable("user-name") String userName,@PathVariable("book-id") String bookId){
        return subscriptionService.getSubscription(userName,bookId);
    }

    @GetMapping("/api/v1/digitalbooks/readers/{user-name}/books/{book-id}/read")
    @PreAuthorize("hasRole('User')")
    public ResponseEntity getSubscriptionAndRead(@PathVariable("user-name") String userName,@PathVariable("book-id") String bookId){
        return subscriptionService.getSubscriptionAndRead(userName,bookId);
    }
}
