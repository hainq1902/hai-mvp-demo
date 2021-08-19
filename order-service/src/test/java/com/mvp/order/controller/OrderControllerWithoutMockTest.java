package com.mvp.order.controller;

import java.net.URI;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import com.mvp.order.dto.ProductInfoDto;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
class OrderControllerWithoutMockTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int randomServerPort;

    @Test
    void addNewOrder() throws Exception {
        final String baseUrl = "http://localhost:"+randomServerPort+"/orders/";
        final URI uri = new URI(baseUrl);

        final ProductInfoDto productInfoDto = new ProductInfoDto(1L, "name", 1, 10.2D);
        HttpEntity<ProductInfoDto> request = new HttpEntity<>(productInfoDto, new HttpHeaders());
        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);

        //Verify request succeed
        Assertions.assertEquals(201, result.getStatusCodeValue());
    }
}