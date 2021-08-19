package com.mvp.product.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ProductInfoDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private final Map<Long, String> attributes = new HashMap<>();
    private final Map<Long, List<String>> attributeValues = new HashMap<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Map<Long, String> getAttributes() {
        return attributes;
    }

    public Map<Long, List<String>> getAttributeValues() {
        return attributeValues;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductInfoDto that = (ProductInfoDto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
