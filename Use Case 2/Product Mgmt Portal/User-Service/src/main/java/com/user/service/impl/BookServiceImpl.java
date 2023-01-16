package com.user.service.impl;

import com.user.nonentity.Response;
import com.user.output.BookResponse;
import com.user.output.SaveBookResponse;
import com.user.service.IBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements IBookService {

    private final RestTemplate restTemplate;

    private static final String BOOK_SAVED_SUCCESSFULLY = "Saved data successfully";

    private static final String BOOK_UPDATED_SUCCESSFULLY = "Updated data successfully";
    @Override
    public List<BookResponse> fetchBooksByDetails(String category, String title, String author, int price, String publisher){
        String url="http://localhost:8087/booksMicroService/api/v1/digitalbooks/search?category="
                +category+"&title="+title+"&author="+author+"&price="+price+"&publisher="+publisher;
        List<BookResponse> bookResponseList =
                Arrays.stream(Objects.requireNonNull(restTemplate.getForObject(url, BookResponse[].class)))
                        .collect(Collectors.toList());
        return bookResponseList;
    }

    @Override
    public Boolean activeStatus(String bookId) {
        String url="http://localhost:8087/booksMicroService/api/v1/digitalbooks/getActiveStatus/"+bookId;
        return restTemplate.getForEntity(url,Boolean.class).getBody();
    }

    @Override
    public Object getBookContent(String bookId) {
        String url="http://localhost:8087/booksMicroService/api/v1/digitalbooks/getBookContent/"+bookId;
        return restTemplate.getForObject(url,Object.class);
    }

    @Override
    public BookResponse updateStatus(boolean active, String userName, String bookId) {
        String url = "http://localhost:8087/booksMicroService/api/v1/digitalbooks/author/{author-id}/books/{book-id}";
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity httpEntity = new HttpEntity<>(httpHeaders);
        Map<String,Object> map = new HashMap<>();
        map.put("author-id",userName);
        map.put("book-id",bookId);
        String  uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(url)
                        .queryParam("block",active)
                        .buildAndExpand(map)
                        .toUriString();
        //BookResponse bookResponse = restTemplate.exchange(uriComponentsBuilder.buildAndExpand(map).toUri(), HttpMethod.POST,httpEntity,BookResponse.class).getBody();
        BookResponse bookResponse = restTemplate.postForEntity(uriComponentsBuilder,httpEntity,BookResponse.class).getBody();
        return bookResponse;
    }

    @Override
    public ResponseEntity saveBook(SaveBookResponse saveBookResponse, String userName) {
        String url = "http://localhost:8087/booksMicroService/api/v1/digitalbooks/author/{author-id}/books";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<SaveBookResponse> httpEntity = new HttpEntity<>(saveBookResponse, httpHeaders);
        Map<String,Object> map = new HashMap<>();
        map.put("author-id",userName);
        String  uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(url)
                .buildAndExpand(map)
                .toUriString();
        ResponseEntity responseEntity = restTemplate.postForEntity(uriComponentsBuilder,httpEntity,SaveBookResponse.class);
        Response response = Response.builder()
                .status(HttpStatus.OK.value())
                .message(BOOK_SAVED_SUCCESSFULLY)
                .build();
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity updateBook(SaveBookResponse saveBookResponse, String userName, String bookId) {
        String url = "http://localhost:8087/booksMicroService/api/v1/digitalbooks/author/{author-id}/books/{book-id}";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<SaveBookResponse> httpEntity = new HttpEntity<>(saveBookResponse, httpHeaders);
        Map<String,Object> map = new HashMap<>();
        map.put("author-id",userName);
        map.put("book-id",bookId);
        String  uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(url)
                .buildAndExpand(map)
                .toUriString();

        if(Objects.equals(bookId, getBookById(bookId))){
            ResponseEntity responseEntity = restTemplate.exchange(uriComponentsBuilder,HttpMethod.PUT,httpEntity,SaveBookResponse.class);
            Response response = Response.builder()
                    .status(HttpStatus.OK.value())
                    .message(BOOK_UPDATED_SUCCESSFULLY)
                    .build();
            return ResponseEntity.ok(response);
        }
        else{
            Response response = Response.builder()
                    .status(200)
                    .message("Book Not Found")
                    .build();
            return ResponseEntity.ok(response);
        }
    }

    public String getBookById(String bookId){
        String url = "http://localhost:8087/booksMicroService/api/v1/digitalbooks/getBook/"+bookId;
        return restTemplate.getForEntity(url,String.class).getBody();
    }

    public Object getAllBooks(){
        String url = "http://localhost:8087/booksMicroService/api/v1/digitalbooks/getAllBooks";
        return restTemplate.getForObject(url,Object.class);
    }
}
