package com.mvp.product.util;

import java.util.List;

public class AttributeSearchCriterion {
    private final Long attributeId;
    private final SearchOperator operator;
    private final List<String> values;

    public AttributeSearchCriterion(Long attributeId, SearchOperator operator, List<String> values) {
        this.attributeId = attributeId;
        this.operator = operator;
        this.values = values;
    }

    public Long getAttributeId() {
        return attributeId;
    }

    public SearchOperator getOperator() {
        return operator;
    }

    public List<String> getValues() {
        return values;
    }
}
