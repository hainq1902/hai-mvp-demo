package com.mvp.product.util;

import java.util.ArrayList;
import java.util.List;

import com.mvp.product.repository.model.Attribute;
import com.mvp.product.repository.model.AttributeValue;
import com.mvp.product.repository.model.Product;
import com.mvp.product.repository.model.ProductType;

public final class DataUtil {

    private DataUtil() {
    }

    public static List<Product> buildHeadphoneProduct(ProductType productType, List<AttributeValue> nameValues, List<AttributeValue> descriptionValues,
                                               List<AttributeValue> categoryValues, List<AttributeValue> priceValues,
                                               List<AttributeValue> brandValues, List<AttributeValue> colourValues) {

        ProductBuilder productBuilder = new ProductBuilder();
        final List<Product> products = new ArrayList<>();

        products.add(productBuilder.withProductType(productType)
                                    .withAttributeValue(nameValues.get(0))
                                    .withAttributeValue(descriptionValues.get(0))
                                    .withAttributeValue(categoryValues.get(0))
                                    .withAttributeValue(priceValues.get(0))
                                    .withAttributeValue(brandValues.get(0))
                                    .withAttributeValue(colourValues.get(0))
                                    .build());

        productBuilder = new ProductBuilder();
        products.add(productBuilder.withProductType(productType)
                                    .withAttributeValue(nameValues.get(1))
                                    .withAttributeValue(descriptionValues.get(1))
                                    .withAttributeValue(categoryValues.get(1))
                                    .withAttributeValue(priceValues.get(1))
                                    .withAttributeValue(brandValues.get(1))
                                    .withAttributeValue(colourValues.get(1))
                                    .build());

        productBuilder = new ProductBuilder();
        products.add(productBuilder.withProductType(productType)
                                    .withAttributeValue(nameValues.get(2))
                                    .withAttributeValue(descriptionValues.get(2))
                                    .withAttributeValue(categoryValues.get(2))
                                    .withAttributeValue(priceValues.get(2))
                                    .withAttributeValue(brandValues.get(2))
                                    .withAttributeValue(colourValues.get(2))
                                    .build());

        productBuilder = new ProductBuilder();
        products.add(productBuilder.withProductType(productType)
                                    .withAttributeValue(nameValues.get(3))
                                    .withAttributeValue(descriptionValues.get(3))
                                    .withAttributeValue(categoryValues.get(3))
                                    .withAttributeValue(priceValues.get(3))
                                    .withAttributeValue(brandValues.get(3))
                                    .withAttributeValue(colourValues.get(3))
                                    .build());

        productBuilder = new ProductBuilder();
        products.add(productBuilder.withProductType(productType)
                                    .withAttributeValue(nameValues.get(4))
                                    .withAttributeValue(descriptionValues.get(4))
                                    .withAttributeValue(categoryValues.get(4))
                                    .withAttributeValue(priceValues.get(4))
                                    .withAttributeValue(brandValues.get(4))
                                    .withAttributeValue(colourValues.get(3))
                                    .build());

        productBuilder = new ProductBuilder();
        products.add(productBuilder.withProductType(productType)
                                    .withAttributeValue(nameValues.get(0))
                                    .withAttributeValue(descriptionValues.get(1))
                                    .withAttributeValue(categoryValues.get(2))
                                    .withAttributeValue(priceValues.get(3))
                                    .withAttributeValue(brandValues.get(4))
                                    .withAttributeValue(colourValues.get(0))
                                    .build());

        productBuilder = new ProductBuilder();
        products.add(productBuilder.withProductType(productType)
                                    .withAttributeValue(nameValues.get(1))
                                    .withAttributeValue(descriptionValues.get(2))
                                    .withAttributeValue(categoryValues.get(3))
                                    .withAttributeValue(priceValues.get(4))
                                    .withAttributeValue(brandValues.get(1))
                                    .withAttributeValue(colourValues.get(2))
                                    .build());

        return products;
    }

    public static ProductType buildHeadphoneProductType(List<AttributeValue> nameValues, List<AttributeValue> descriptionValues,
                                                        List<AttributeValue> categoryValues, List<AttributeValue> priceValues, List<AttributeValue> brandValues, List<AttributeValue> colourValues) {
        ProductTypeBuilder productTypeBuilder = new ProductTypeBuilder();
        return productTypeBuilder.withName("headphone")
                .withDescription("headphone")
                .withAttributeValues(nameValues)
                .withAttributeValues(descriptionValues)
                .withAttributeValues(categoryValues)
                .withAttributeValues(priceValues)
                .withAttributeValues(brandValues)
                .withAttributeValues(colourValues)
                .build();
    }

    public static List<Attribute> buildAttributes(List<AttributeValue> nameValues, List<AttributeValue> descriptionValues,
                                                  List<AttributeValue> categoryValues, List<AttributeValue> priceValues,
                                                  List<AttributeValue> brandValues, List<AttributeValue> colourValues) {
        final List<Attribute> attributes = new ArrayList<>();
        AttributeBuilder attributeBuilder = new AttributeBuilder();
        attributes.add(attributeBuilder.withName("category")
                .withDescription("category")
                .withValues(categoryValues)
                .build());
        attributeBuilder = new AttributeBuilder();
        attributes.add(attributeBuilder.withName("price")
                .withDescription("price")
                .withValues(priceValues)
                .build());
        attributeBuilder = new AttributeBuilder();
        attributes.add(attributeBuilder.withName("brand")
                .withDescription("brand")
                .withValues(brandValues)
                .build());
        attributeBuilder = new AttributeBuilder();
        attributes.add(attributeBuilder.withName("colour")
                .withDescription("colour")
                .withValues(colourValues)
                .build());

        attributeBuilder = new AttributeBuilder();
        attributes.add(attributeBuilder.withName("name")
                .withDescription("name")
                .withValues(nameValues)
                .build());

        attributeBuilder = new AttributeBuilder();
        attributes.add(attributeBuilder.withName("description")
                .withDescription("description")
                .withValues(descriptionValues)
                .build());
        return attributes;
    }

    public static List<AttributeValue> buildColourValues() {
        final List<AttributeValue> colourValues = new ArrayList<>();
        colourValues.add(new AttributeValue("colour", "colour", "Black"));
        colourValues.add(new AttributeValue("colour", "colour", "Grey"));
        colourValues.add(new AttributeValue("colour", "colour", "Brown"));
        colourValues.add(new AttributeValue("colour", "colour", "Yellow"));
        return colourValues;
    }

    public static List<AttributeValue> buildBrandValues() {
        final List<AttributeValue> brandValues = new ArrayList<>();
        brandValues.add(new AttributeValue("brand", "brand name", "Campfire Audio"));
        brandValues.add(new AttributeValue("brand", "brand name", "Focal"));
        brandValues.add(new AttributeValue("brand", "brand name", "Dan Clark"));
        brandValues.add(new AttributeValue("brand", "brand name", "Empfire Ears"));
        brandValues.add(new AttributeValue("brand", "brand name", "64 Audio"));
        return brandValues;
    }

    public static List<AttributeValue> buildPriceValues() {
        final List<AttributeValue> priceValues = new ArrayList<>();
        priceValues.add(new AttributeValue("price", "headphone price value in USD", "2199"));
        priceValues.add(new AttributeValue("price", "headphone price value in USD", "1200"));
        priceValues.add(new AttributeValue("price", "headphone price value in USD", "2500"));
        priceValues.add(new AttributeValue("price", "headphone price value in USD", "1240"));
        priceValues.add(new AttributeValue("price", "headphone price value in USD", "1999"));
        return priceValues;
    }

    public static List<AttributeValue> buildCategoryValues() {
        final List<AttributeValue> categoryValues = new ArrayList<>();
        categoryValues.add(new AttributeValue("category", "headphone category value", "Full size"));
        categoryValues.add(new AttributeValue("category", "headphone category value", "Over-head"));
        categoryValues.add(new AttributeValue("category", "headphone category value", "On ears"));
        categoryValues.add(new AttributeValue("category", "headphone category value", "IEMs"));
        categoryValues.add(new AttributeValue("category", "headphone category value", "Ear phones"));
        return categoryValues;
    }

    public static List<AttributeValue> buildDescriptionalues() {
        final List<AttributeValue> descriptionValues = new ArrayList<>();
        descriptionValues.add(new AttributeValue("description", "headphone description value", "Focal Clear"));
        descriptionValues.add(new AttributeValue("description", "headphone description value", "MrSpeakers Ether 2"));
        descriptionValues.add(new AttributeValue("description", "headphone description value", "Empire ESK MK2"));
        descriptionValues.add(new AttributeValue("description", "headphone description value", "Campfire Solaris"));
        descriptionValues.add(new AttributeValue("description", "headphone description value", "64 Audio 6ts"));
        return descriptionValues;
    }

    public static List<AttributeValue> buildNameValues() {
        final List<AttributeValue> nameValues = new ArrayList<>();
        nameValues.add(new AttributeValue("name", "headphone name value", "Focal Clear"));
        nameValues.add(new AttributeValue("name", "headphone name value", "MrSpeakers Ether 2"));
        nameValues.add(new AttributeValue("name", "headphone name value", "Empire ESK MK2"));
        nameValues.add(new AttributeValue("name", "headphone name value", "Campfire Solaris"));
        nameValues.add(new AttributeValue("name", "headphone name value", "64 Audio 6ts"));
        return nameValues;
    }

}
