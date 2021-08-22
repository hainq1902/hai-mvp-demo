package com.mvp.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mvp.product.repository.model.Attribute;

@Repository
public interface AttributeRepository extends JpaRepository<Attribute, Long> {

}
