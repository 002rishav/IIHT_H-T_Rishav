package com.user.service.impl;

import com.user.nonentity.Response;
import com.user.output.SaveProductResponse;
import com.user.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.*;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {

    private final RestTemplate restTemplate;

    private static final String PRODUCT_SAVED_SUCCESSFULLY = "Saved data successfully";

    private static final String PRODUCT_UPDATED_SUCCESSFULLY = "Updated data successfully";

    @Override
    public ResponseEntity saveProduct(SaveProductResponse saveProductResponse) {
        String url = "http://localhost:8087/productsMicroService/api/v1/save/products";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<SaveProductResponse> httpEntity = new HttpEntity<>(saveProductResponse, httpHeaders);
        String  uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(url)
                .toUriString();
        ResponseEntity responseEntity = restTemplate.postForEntity(uriComponentsBuilder,httpEntity,SaveProductResponse.class);
        Response response = Response.builder()
                .status(HttpStatus.OK.value())
                .message(PRODUCT_SAVED_SUCCESSFULLY)
                .build();
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity updateProduct(SaveProductResponse saveProductResponse, String name) {
        String url = "http://localhost:8087/productsMicroService/api/v1/update/products/{name}";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<SaveProductResponse> httpEntity = new HttpEntity<>(saveProductResponse, httpHeaders);
        Map<String,Object> map = new HashMap<>();
        map.put("name",name);
        String  uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(url)
                .buildAndExpand(map)
                .toUriString();

        if(Objects.equals(name, getProductByName(name))){
            ResponseEntity responseEntity = restTemplate.exchange(uriComponentsBuilder,HttpMethod.PUT,httpEntity,SaveProductResponse.class);
            Response response = Response.builder()
                    .status(HttpStatus.OK.value())
                    .message(PRODUCT_UPDATED_SUCCESSFULLY)
                    .build();
            return ResponseEntity.ok(response);
        }
        else{
            Response response = Response.builder()
                    .status(200)
                    .message("Product Not Found")
                    .build();
            return ResponseEntity.ok(response);
        }
    }

    public String getProductByName(String name){
        String url = "http://localhost:8087/productsMicroService/api/v1/getProduct/"+name;
        return restTemplate.getForEntity(url,String.class).getBody();
    }

    public Object getAllProducts(){
        String url = "http://localhost:8087/productsMicroService/api/v1/getAllProducts";
        return restTemplate.getForObject(url,Object.class);
    }
}
