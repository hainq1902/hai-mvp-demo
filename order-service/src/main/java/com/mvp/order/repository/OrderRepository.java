package com.mvp.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mvp.order.repository.model.OrderSummary;

@Repository
public interface OrderRepository extends JpaRepository<OrderSummary, Long> {

    OrderSummary findOrderByOrderNumber(String orderNumber);
}