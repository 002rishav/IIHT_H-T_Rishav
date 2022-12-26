package com.user.service.impl;

import com.user.entity.SubscriptionDetail;
import com.user.enums.ErrorCodes;
import com.user.exception.GlobalException;
import com.user.nonentity.Response;
import com.user.repository.SubscriptionDetailRepo;
import com.user.service.IBookService;
import com.user.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionDetailRepo subscriptionDetailRepo;

    private final IBookService bookService;

    @Value("${book.unsubscribe.duration.hours}")
    private long unsubscribeDuration;

    @Override
    public ResponseEntity saveSubscriptionDetails(String bookId, String userName) {
        Response response;
        boolean activeStatus = bookService.activeStatus(bookId);
        if(!activeStatus){
            log.info("Cannot Subscribe as the book is blocked.");
            response = Response.builder().status(403).message("Cannot Subscribe as the book is blocked.").build();
            return ResponseEntity.ok(response);
        }
        SubscriptionDetail subscriptionDetail=SubscriptionDetail.builder()
                .bookId(bookId)
                .userName(userName)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        subscriptionDetailRepo.save(subscriptionDetail);
        response = Response.builder()
                .status(HttpStatus.OK.value())
                .message("Book Subscribed")
                .build();
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity cancelSubscription(String bookId, String userName){
        Optional<SubscriptionDetail> optionalSubscriptionDetail = subscriptionDetailRepo.findByBookIdAndUserName(bookId,userName);
        Response response;

        if(!optionalSubscriptionDetail.isPresent()){
            log.info("Empty subscription entity found");
            response = Response.builder()
                    .status(403)
                    .message("Subscription not found").build();
            return ResponseEntity.ok(response);
        }
        try{
            SubscriptionDetail subscriptionDetail = optionalSubscriptionDetail.get();
            Duration duration = Duration.between(subscriptionDetail.getUpdatedAt(),LocalDateTime.now());
            if(duration.toHours()>unsubscribeDuration){
                response = Response.builder()
                        .status(400)
                        .message("Cannot un-subscribe").build();
                return ResponseEntity.ok(response);
            }
            subscriptionDetailRepo.deleteById(subscriptionDetail.getId());
            response = Response.builder()
                    .status(200)
                    .message("Un-subscribed successfully").build();
            return ResponseEntity.ok(response);
        }
        catch(Exception e) {
            log.info("Unable to un-subscribe:{}", e.getMessage());
            throw new GlobalException(ErrorCodes.BOOK_EXP_001);
        }
    }

    @Override
    public ResponseEntity getAllSubscriptions(String userName) {
        Optional<List<SubscriptionDetail>> optionalSubscriptionDetail = subscriptionDetailRepo.findByUserName(userName);

        Response response ;
        if(!optionalSubscriptionDetail.isPresent())
        {
            log.info("Empty subscriptions entity found");
            response = Response.builder()
                    .status(200)
                    .message("Subscription not found").build();
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.ok(optionalSubscriptionDetail);
    }

    @Override
    public ResponseEntity getSubscription(String userName, String bookId) {
        Optional<SubscriptionDetail> optionalSubscriptionDetail = subscriptionDetailRepo.findByBookIdAndUserName(bookId,userName);

        Response response ;
        if(!optionalSubscriptionDetail.isPresent())
        {
            log.info("Empty subscriptions entity found");
            response = Response.builder()
                    .status(200)
                    .message("Subscription not found").build();
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.ok(optionalSubscriptionDetail);
    }

    @Override
    public ResponseEntity getSubscriptionAndRead(String userName, String bookId) {
        Optional<SubscriptionDetail> optionalSubscriptionDetail = subscriptionDetailRepo.findByBookIdAndUserName(bookId,userName);
        Response response;
        if(!optionalSubscriptionDetail.isPresent()){
            log.info("Book is not subscribed");
            response = Response.builder()
                    .status(200)
                    .message("Book is not subscribed").build();
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.ok(bookService.getBookContent(bookId));
    }
}
