package com.mvp.product.util;

import java.util.ArrayList;
import java.util.List;

import com.mvp.product.repository.model.Attribute;
import com.mvp.product.repository.model.AttributeValue;

public class AttributeBuilder {

    private String name;
    private String description;
    private List<AttributeValue> values = new ArrayList<>();


    public AttributeBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public AttributeBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public AttributeBuilder withValue(AttributeValue value) {
        values.add(value);
        return this;
    }

    public AttributeBuilder withValues(List<AttributeValue> attributeValues) {
        values.addAll(attributeValues);
        return this;
    }

    public Attribute build() {
        final Attribute attribute = new Attribute(name, description);
        values.forEach(value -> value.setAttribute(attribute));
        attribute.setValues(values);
        return attribute;
    }
}
