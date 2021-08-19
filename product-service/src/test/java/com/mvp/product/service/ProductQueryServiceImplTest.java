package com.mvp.product.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mvp.product.ProductServiceApplication;
import com.mvp.product.dto.ProductInfoDto;
import com.mvp.product.repository.ProductSpecification;
import com.mvp.product.util.AttributeSearchCriterion;
import com.mvp.product.util.SearchOperator;

@SpringBootTest(classes = ProductServiceApplication.class)
class ProductQueryServiceImplTest {

    @Autowired
    private ProductQueryServiceImpl productQueryService;

    @Test
    void findAll() {
        final List<ProductInfoDto> productInfoDtos = productQueryService.findAll();
        Assertions.assertNotNull(productInfoDtos);
        Assertions.assertTrue(productInfoDtos.size() > 0);
    }

    @Test
    void testFindAll() {
        final AttributeSearchCriterion criterion = new AttributeSearchCriterion(1L, SearchOperator.IN,
                Arrays.asList("Full size", "Over-head", "On ears", "IEMs", "Ear phones"));
        final ProductSpecification specification = new ProductSpecification(Collections.singletonList(criterion));
        final List<ProductInfoDto> productInfoDtos = productQueryService.findAll(specification);
        Assertions.assertNotNull(productInfoDtos);
        Assertions.assertTrue(productInfoDtos.size() > 0);
    }
}