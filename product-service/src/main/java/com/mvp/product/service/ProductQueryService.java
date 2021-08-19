package com.mvp.product.service;

import java.util.List;

import com.mvp.product.dto.ProductInfoDto;
import com.mvp.product.repository.ProductSpecification;

public interface ProductQueryService {
    List<ProductInfoDto> findAll();

    List<ProductInfoDto> findAll(ProductSpecification productSpecification);
}
