package com.mvp.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mvp.product.repository.model.AttributeValue;

public interface AttributeValueRepository extends JpaRepository<AttributeValue, Long> {
}
