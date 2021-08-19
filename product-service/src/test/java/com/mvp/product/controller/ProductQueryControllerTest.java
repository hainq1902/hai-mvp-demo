package com.mvp.product.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductQueryControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int randomServerPort;

    @Test
    void all() throws URISyntaxException {
        final String baseUrl = "http://localhost:"+randomServerPort+"/products";

        final URI uri = new URI(baseUrl);
        final ResponseEntity<String> result = this.restTemplate.getForEntity(uri, String.class);

        //Verify request succeed
        Assertions.assertEquals(200, result.getStatusCodeValue());
    }
}