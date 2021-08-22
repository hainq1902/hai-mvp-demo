package com.mvp.product.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.mvp.product.repository.model.AttributeValue;
import com.mvp.product.repository.model.Product;
import com.mvp.product.repository.model.ProductAttributeValues;
import com.mvp.product.repository.model.ProductType;

public class ProductBuilder {
    private ProductType productType;
    private final List<AttributeValue> attributeValues = new ArrayList<>();

    public ProductBuilder withProductType(ProductType productType) {
        this.productType = productType;
        return this;
    }

    public ProductBuilder withAttributeValue(AttributeValue value) {
        attributeValues.add(value);
        return this;
    }


    public Product build() {
        final Product product = new Product();
        product.setProductType(productType);
        product.setProductAttributeValues(attributeValues.stream()
                .map(value -> new ProductAttributeValues(product, value))
                .collect(Collectors.toList()));
        return product;
    }
}
