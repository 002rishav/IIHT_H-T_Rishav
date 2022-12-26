package com.user;

import com.user.entity.SubscriptionDetail;
import com.user.enums.ErrorCodes;
import com.user.exception.GlobalException;
import com.user.nonentity.Response;
import com.user.repository.SubscriptionDetailRepo;
import com.user.service.IBookService;
import com.user.service.impl.BookServiceImpl;
import com.user.service.impl.SubscriptionServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class SubscriptionServiceImplTest {

    @InjectMocks
    private SubscriptionServiceImpl subscriptionService;

    @Mock
    private IBookService bookService;

    @Mock
    SubscriptionDetailRepo subscriptionDetailRepo;

    @Test
    public void saveSubscriptionWhenNotActiveTest(){
        String bookId = "Book123";
        String userName = "Rishav11";
        boolean activeStatus = false;
        SubscriptionDetail mockSubscriptionDetail = Mockito.mock(SubscriptionDetail.class);
        Mockito.lenient().when(subscriptionDetailRepo.save(any())).thenReturn(mockSubscriptionDetail);
        Mockito.when(bookService.activeStatus(bookId)).thenReturn(activeStatus);
        Response response = Response.builder()
                .status(403)
                .message("Cannot Subscribe as the book is blocked.")
                .build();
        assertEquals(response,(Response) subscriptionService.saveSubscriptionDetails(bookId,userName).getBody());
    }

    @Test
    public void saveSubscriptionWhenActiveTest(){
        String bookId = "Book123";
        String userName = "Rishav11";
        boolean activeStatus = true;
        SubscriptionDetail mockSubscriptionDetail = Mockito.mock(SubscriptionDetail.class);
        Mockito.when(subscriptionDetailRepo.save(any())).thenReturn(mockSubscriptionDetail);
        Mockito.when(bookService.activeStatus(bookId)).thenReturn(activeStatus);
        Response response = Response.builder()
                .status(HttpStatus.OK.value())
                .message("Book Subscribed")
                .build();
        assertEquals(response,(Response) subscriptionService.saveSubscriptionDetails(bookId,userName).getBody());
    }

    @Test
    public void getAllSubscriptionsTest(){
        String userName = "XYZ";
        SubscriptionDetail mockSubscriptionDetail = Mockito.mock(SubscriptionDetail.class);
        Mockito.lenient().when(subscriptionDetailRepo.save(any())).thenReturn(mockSubscriptionDetail);
        Response response = Response.builder()
                .status(200)
                .message("Subscription not found").build();
        assertEquals(response,(Response) subscriptionService.getAllSubscriptions(userName).getBody());
    }

    @Test
    public void getSubscriptionsTest(){
        String userName = "XYZ";
        String bookId = "Book123";
        SubscriptionDetail mockSubscriptionDetail = Mockito.mock(SubscriptionDetail.class);
        Mockito.lenient().when(subscriptionDetailRepo.save(any())).thenReturn(mockSubscriptionDetail);
        Response response = Response.builder()
                .status(200)
                .message("Subscription not found").build();
        assertEquals(response,(Response) subscriptionService.getSubscription(userName,bookId).getBody());
    }

    @Test
    public void getSubscriptionsAndReadTest(){
        String userName = "XYZ";
        String bookId = "Book123";
        SubscriptionDetail mockSubscriptionDetail = Mockito.mock(SubscriptionDetail.class);
        Mockito.lenient().when(subscriptionDetailRepo.save(any())).thenReturn(mockSubscriptionDetail);
        Response response = Response.builder()
                .status(200)
                .message("Book is not subscribed").build();
        assertEquals(response,(Response) subscriptionService.getSubscriptionAndRead(userName,bookId).getBody());
    }

    @Test
    public void cancelSubscriptionWhenSubscriptionIsNotPresentTest(){
        String userName = "XYZ";
        String bookId = "Book123";
        SubscriptionDetail mockSubscriptionDetail = Mockito.mock(SubscriptionDetail.class);
        Mockito.lenient().when(subscriptionDetailRepo.save(any())).thenReturn(mockSubscriptionDetail);
        Response response = Response.builder()
                .status(403)
                .message("Subscription not found").build();
        assertEquals(response,(Response) subscriptionService.cancelSubscription(userName,bookId).getBody());
    }

    @Test
    public void cancelSubscriptionWhenSubscriptionIsPresentAndDurationLessTest(){
        String userName = "XYZ";
        String bookId = "Book123";
        SubscriptionDetail mockSubscriptionDetail = Mockito.mock(SubscriptionDetail.class);
        Mockito.lenient().when(subscriptionDetailRepo.findByBookIdAndUserName(userName,bookId)).thenReturn(Optional.of(mockSubscriptionDetail));
        Mockito.when(mockSubscriptionDetail.getUpdatedAt()).thenReturn(LocalDateTime.now());
        Response response = Response.builder()
                .status(200)
                .message("Un-subscribed successfully").build();
        assertEquals(response, (Response) subscriptionService.cancelSubscription(userName,bookId).getBody());
    }

    @Test
    public void cancelSubscriptionWhenSubscriptionIsPresentAndDurationMoreTest(){
        String userName = "XYZ";
        String bookId = "Book123";
        SubscriptionDetail mockSubscriptionDetail = Mockito.mock(SubscriptionDetail.class);
        Mockito.lenient().when(subscriptionDetailRepo.findByBookIdAndUserName(userName,bookId)).thenReturn(Optional.of(mockSubscriptionDetail));
        Mockito.when(mockSubscriptionDetail.getUpdatedAt()).thenReturn(LocalDateTime.of(2022,12,23,12,20));
        Response response = Response.builder()
                .status(400)
                .message("Cannot un-subscribe").build();
        assertEquals(response, (Response) subscriptionService.cancelSubscription(userName,bookId).getBody());
    }

    @Test
    public void cancelSubscriptionWhenSubscriptionIsPresentExceptionTest(){
        String userName = "XYZ";
        String bookId = "Book123";
        SubscriptionDetail mockSubscriptionDetail = Mockito.mock(SubscriptionDetail.class);
        Mockito.lenient().when(subscriptionDetailRepo.findByBookIdAndUserName(userName,bookId)).thenReturn(Optional.of(mockSubscriptionDetail));
        assertThrows(GlobalException.class, () -> subscriptionService.cancelSubscription(userName,bookId));
//        subscriptionService.cancelSubscription(userName,bookId);
    }
}
