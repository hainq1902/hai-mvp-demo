package com.mvp.product.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.mvp.product.repository.model.Product;
import com.mvp.product.repository.model.ProductAttributeValues;
import com.mvp.product.util.AttributeSearchCriterion;

public class ProductSpecification implements Specification<Product> {
    private final List<AttributeSearchCriterion> searchCriteria;

    public ProductSpecification(List<AttributeSearchCriterion> searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    @Override
    public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        final List<Predicate> predicates = new ArrayList<>();
        final ListJoin<Product, ProductAttributeValues> values = root.joinList("productAttributeValues");
        final Path<?> attributeValuePath = values.get("attributeValue");
        final String valueAttribute = "value";
        Predicate predicate;
        for(AttributeSearchCriterion criterion : searchCriteria) {
            predicate = criteriaBuilder.equal(attributeValuePath.get("attribute").get("id"), criterion.getAttributeId());
            switch (criterion.getOperator()) {
                case EQUAL:
                    predicates.add(criteriaBuilder.and(predicate, criteriaBuilder.equal(
                                                attributeValuePath.get(valueAttribute),criterion.getValues().get(0))));
                    break;
                case IN:
                    final CriteriaBuilder.In<String> in = criteriaBuilder.in(attributeValuePath.get(valueAttribute));
                    criterion.getValues().forEach(in::value);
                    predicates.add(criteriaBuilder.and(predicate, in));
                    break;
                case RANGE:
                    predicates.add(criteriaBuilder.and(predicate, criteriaBuilder.between(
                                                            attributeValuePath.get(valueAttribute),
                                                            Double.parseDouble(criterion.getValues().get(0)),
                                                            Double.parseDouble(criterion.getValues().get(1)))));
                    break;
            }
        }
        return criteriaBuilder.or(predicates.toArray(new Predicate[0]));
    }
}
