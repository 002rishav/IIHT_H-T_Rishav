package com.user.utility;

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
public class ProductServiceUtility implements IProductService {

    private final RestTemplate restTemplate;

    private static final String PRODUCT_SAVED_SUCCESSFULLY = "Saved data successfully";

    private static final String PRODUCT_UPDATED_SUCCESSFULLY = "Updated data successfully";
    
    private static final String PRODUCT_DELETED_SUCCESSFULLY = "Deleted successfully";

    @Override
    public ResponseEntity saveProduct(SaveProductResponse saveProductResponse) {
        String url = "http://localhost:8087/productsMicroService/api/v1";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<SaveProductResponse> httpEntity = new HttpEntity<>(saveProductResponse, httpHeaders);
        String  uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(url)
                .toUriString();
        ResponseEntity responseEntity = restTemplate.postForEntity(uriComponentsBuilder,httpEntity,SaveProductResponse.class);
        Response response = Response.builder()
                .status(HttpStatus.CREATED.value())
                .message(PRODUCT_SAVED_SUCCESSFULLY)
                .build();
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity updateProduct(SaveProductResponse saveProductResponse, int id) {
        String url = "http://localhost:8087/productsMicroService/api/v1/{id}";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<SaveProductResponse> httpEntity = new HttpEntity<>(saveProductResponse, httpHeaders);
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        String  uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(url)
                .buildAndExpand(map)
                .toUriString();

        if(Objects.equals(id, getProductById(id))){
            ResponseEntity responseEntity = restTemplate.exchange(uriComponentsBuilder,HttpMethod.PUT,httpEntity,SaveProductResponse.class);
            Response response = Response.builder()
                    .status(HttpStatus.OK.value())
                    .message(PRODUCT_UPDATED_SUCCESSFULLY)
                    .build();
            return ResponseEntity.ok(response);
        }
        else{
            Response response = Response.builder()
                    .status(500)
                    .message("Product Not Found")
                    .build();
            return ResponseEntity.ok(response);
        }
    }

    public Integer getProductById(int id){
        String url = "http://localhost:8087/productsMicroService/api/v1/"+id;
        return restTemplate.getForEntity(url,Integer.class).getBody();
    }

    public Object getAllProducts(){
        String url = "http://localhost:8087/productsMicroService/api/v1/AllProducts";
        return restTemplate.getForObject(url,Object.class);
    }

	@Override
	public ResponseEntity deleteProduct(int id) {
		String url = "http://localhost:8087/productsMicroService/api/v1/" + id;

        if(Objects.equals(id, getProductById(id))){
            restTemplate.delete(url);
            Response response = Response.builder()
                    .status(204)
                    .message(PRODUCT_DELETED_SUCCESSFULLY)
                    .build();
            return ResponseEntity.ok(response);
        }
        else{
            Response response = Response.builder()
                    .status(500)
                    .message("Product Not Found")
                    .build();
            return ResponseEntity.ok(response);
        }
	}
}
