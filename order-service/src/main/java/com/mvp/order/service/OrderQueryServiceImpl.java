package com.mvp.order.service;

import org.springframework.stereotype.Service;

import com.mvp.order.dto.OrderInfoDto;
import com.mvp.order.repository.OrderRepository;
import com.mvp.order.util.DtoUtils;

@Service
public class OrderQueryServiceImpl implements OrderQueryService {
    private final OrderRepository orderRepository;

    public OrderQueryServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderInfoDto findByOrderNumber(String orderNumber) {
        return DtoUtils.toOrderInfoDto(orderRepository.findOrderByOrderNumber(orderNumber));
    }

}
