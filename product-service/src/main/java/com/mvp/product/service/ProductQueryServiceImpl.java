package com.mvp.product.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.mvp.product.dto.ProductInfoDto;
import com.mvp.product.repository.ProductRepository;
import com.mvp.product.repository.ProductSpecification;
import com.mvp.product.repository.model.Product;

@Service
public class ProductQueryServiceImpl implements ProductQueryService {
    private final ProductRepository productRepository;

    public ProductQueryServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductInfoDto> findAll() {
        return productRepository.findAll()
                .stream()
                .map(ProductQueryServiceImpl::toProductInfoDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductInfoDto> findAll(ProductSpecification productSpecification) {
        return productRepository.findAll(productSpecification)
                .stream()
                .map(ProductQueryServiceImpl::toProductInfoDto)
                .collect(Collectors.toList());
    }

    private static ProductInfoDto toProductInfoDto(Product product) {
        final ProductInfoDto productInfoDto = new ProductInfoDto();
        productInfoDto.setId(product.getId());
        productInfoDto.getAttributes().putAll(
                product.getProductAttributeValues()
                        .stream()
                        .collect(Collectors.toMap((val) -> val.getAttributeValue().getAttribute().getId(),
                                (val) -> val.getAttributeValue().getAttribute().getName())));


        product.getProductAttributeValues().forEach(values -> {
            productInfoDto.getAttributeValues().putIfAbsent(values.getAttributeValue().getAttribute().getId(),
                    new ArrayList<>());
            productInfoDto.getAttributeValues().get(values.getAttributeValue().getAttribute().getId())
                    .add(values.getAttributeValue().getValue());
        });
        return productInfoDto;
    }
}
