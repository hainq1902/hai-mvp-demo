package com.mvp.product.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.mvp.product.repository.model.AttributeValue;
import com.mvp.product.repository.model.ProductType;
import com.mvp.product.repository.model.ProductTypeAttributeValue;

public class ProductTypeBuilder {

    private String name;
    private String description;
    private final List<AttributeValue> attributeValues = new ArrayList<>();

    public ProductTypeBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public ProductTypeBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public ProductTypeBuilder withAttributeValue(AttributeValue value) {
        attributeValues.add(value);
        return this;
    }

    public ProductTypeBuilder withAttributeValues(List<AttributeValue> values) {
        attributeValues.addAll(values);
        return this;
    }

    public ProductType build() {
        final ProductType productType = new ProductType(name, description);
        productType.setAttributeValues(attributeValues.stream()
                .map(value -> new ProductTypeAttributeValue(productType, value))
                .collect(Collectors.toList()));
        return productType;
    }
}
