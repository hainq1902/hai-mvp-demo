package com.mvp.order.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mvp.order.OrderServiceApplication;
import com.mvp.order.dto.ProductInfoDto;
import com.mvp.order.repository.OrderRepository;
import com.mvp.order.repository.model.OrderSummary;

@SpringBootTest(classes = OrderServiceApplication.class)
class OrderManagementServiceImplTest {

    @Autowired
    private OrderManagementService orderManagementService;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    void createOrder() {
        final String orderNumber = orderManagementService.createOrder(new ProductInfoDto(1L, "product name", 1, 10.5D));
        final OrderSummary order = orderRepository.findOrderByOrderNumber(orderNumber);

        Assertions.assertEquals(1, order.getProducts().size());
    }

    @Test
    void addProductInfo() {
        final String orderNumber = "orderNumber";
        OrderSummary order = new OrderSummary();
        order.setOrderNumber(orderNumber);
        orderRepository.save(order);
        orderManagementService.addProductInfo(orderNumber, new ProductInfoDto(1L, "product name", 1, 10.5D));

        order = orderRepository.findOrderByOrderNumber(orderNumber);
        Assertions.assertNotNull(order);
        Assertions.assertEquals(1, order.getProducts().size());
    }
}