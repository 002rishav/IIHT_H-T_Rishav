package com.user.service;

import org.springframework.http.ResponseEntity;

public interface SubscriptionService {

    public ResponseEntity saveSubscriptionDetails(String bookId,String userName);

    public ResponseEntity cancelSubscription(String bookId, String userName);

    public ResponseEntity getAllSubscriptions(String userName);

    public ResponseEntity getSubscription(String userName, String bookId);

    public ResponseEntity getSubscriptionAndRead(String userName, String bookId);
}
