package com.mvp.order.service;

import java.util.Collections;
import java.util.Optional;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Service;

import com.mvp.order.dto.OrderInfoDto;
import com.mvp.order.dto.ProductInfoDto;
import com.mvp.order.repository.OrderRepository;
import com.mvp.order.repository.model.OrderSummary;
import com.mvp.order.repository.model.OrderedProduct;
import com.mvp.order.util.DtoUtils;

@Service
public class OrderManagementServiceImpl implements OrderManagementService {
    private final OrderRepository orderRepository;

    public OrderManagementServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public String createOrder(ProductInfoDto productInfoDto) {
        final OrderInfoDto orderInfoDto = new OrderInfoDto(generateOrderNumber(),
                                                            Collections.singletonList(productInfoDto));
        orderRepository.save(DtoUtils.toOrderSummary(orderInfoDto));
        return orderInfoDto.getOrderNumber();
    }

    @Override
    public String generateOrderNumber() {
        return RandomStringUtils.randomAlphanumeric(8);
    }

    @Override
    public OrderInfoDto addProductInfo(String orderNumber, ProductInfoDto productInfoDto) {
        final OrderSummary order = orderRepository.findOrderByOrderNumber(orderNumber);
        final Optional<OrderedProduct> product = order.getProducts()
                                .stream()
                                .filter(orderedProduct -> orderedProduct.getProductId().equals(productInfoDto.getId()))
                                .findFirst();

        if (product.isPresent()) {
            product.get().setAmount(product.get().getAmount() + productInfoDto.getAmount());
        }
        else {
            order.getProducts().add(new OrderedProduct(productInfoDto.getId(), productInfoDto.getName(),
                                                        productInfoDto.getPrice(), productInfoDto.getAmount(), order));
        }

        orderRepository.save(order);
        return DtoUtils.toOrderInfoDto(order);
    }
}
