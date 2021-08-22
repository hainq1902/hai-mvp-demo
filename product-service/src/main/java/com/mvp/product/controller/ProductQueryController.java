package com.mvp.product.controller;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mvp.product.dto.ProductInfoDto;
import com.mvp.product.repository.ProductSpecification;
import com.mvp.product.service.ProductQueryService;
import com.mvp.product.util.AttributeSearchCriterion;
import com.mvp.product.util.SearchOperator;

@RestController
public class ProductQueryController {
    private static final Logger log = LoggerFactory.getLogger(ProductQueryController.class);

    private final ProductQueryService productQueryService;
    private final ObjectMapper objectMapper;

    public ProductQueryController(ProductQueryService productQueryService, ObjectMapper objectMapper) {
        this.productQueryService = productQueryService;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/products/{id}")
    public EntityModel<ProductInfoDto> get(@PathVariable Long id) {
        return EntityModel.of(new ProductInfoDto());
    }

    @GetMapping("/products")
    public CollectionModel<EntityModel<ProductInfoDto>> all(@RequestParam(required = false) String filter) {

        List<ProductInfoDto> products;
        if (Objects.nonNull(filter) && filter.length() > 0) {
            try {
                final List<AttributeSearchCriterion> searchCriteria = convertToSearchCriteria(objectMapper.readValue(filter, List.class));
                products = productQueryService.findAll(new ProductSpecification(searchCriteria));
            } catch (JsonProcessingException e) {
                log.error(e.getMessage(), e);
                products = productQueryService.findAll();
            }
        }
        else {
            products = productQueryService.findAll();

        }
        final List<EntityModel<ProductInfoDto>> productEntityModel = products
                .stream()
                .map(productDto -> EntityModel.of(productDto,
                        linkTo(methodOn(ProductQueryController.class).get(productDto.getId())).withRel("product")))
                .collect(Collectors.toList());
        return CollectionModel.of(productEntityModel, linkTo(methodOn(ProductQueryController.class).all(null)).withSelfRel());
    }

    private List<AttributeSearchCriterion> convertToSearchCriteria(List<Map> filters) {
        return filters.stream()
                .map(filter -> new AttributeSearchCriterion( Long.valueOf((Integer) filter.get("attributeId")),
                                                                SearchOperator.valueOf((String) filter.get("operator")),
                                                                (List<String>) filter.get("values")))
                .collect(Collectors.toList());
    }
}
