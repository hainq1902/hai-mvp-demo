package com.mvp.order.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.mvp.order.dto.OrderInfoDto;
import com.mvp.order.dto.ProductInfoDto;
import com.mvp.order.service.OrderManagementService;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
class OrderControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int randomServerPort;

    @MockBean
    private OrderManagementService orderManagementService;

    @Test
    void addItem() throws URISyntaxException {
        final ProductInfoDto productInfoDto = new ProductInfoDto(1L, "name", 1, 10.2D);
        final String baseUrl = "http://localhost:"+randomServerPort+"/orders/orderNumber";

        when(orderManagementService.addProductInfo(any(), any())).thenReturn(new OrderInfoDto("orderNumber", Collections.singletonList(productInfoDto)));
        final URI uri = new URI(baseUrl);

        HttpEntity<ProductInfoDto> request = new HttpEntity<>(productInfoDto, new HttpHeaders());
        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);

        //Verify request succeed
        Assertions.assertEquals(201, result.getStatusCodeValue());
    }
}