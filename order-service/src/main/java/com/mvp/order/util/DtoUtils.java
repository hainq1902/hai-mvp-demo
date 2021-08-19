package com.mvp.order.util;

import java.util.stream.Collectors;

import com.mvp.order.dto.OrderInfoDto;
import com.mvp.order.dto.ProductInfoDto;
import com.mvp.order.repository.model.OrderSummary;
import com.mvp.order.repository.model.OrderedProduct;

public final class DtoUtils {

    private DtoUtils() {}

    public static OrderInfoDto toOrderInfoDto(OrderSummary order) {
        final OrderInfoDto orderInfoDto = new OrderInfoDto();
        orderInfoDto.setOrderNumber(order.getOrderNumber());
        orderInfoDto.setOrderDate(order.getOrderDate());
        orderInfoDto.setDeliveryAddress(order.getDeliveryAddress());
        orderInfoDto.setOrderStatus(order.getOrderStatus());

        orderInfoDto.setProductInfoDtos(order.getProducts()
                .stream()
                .map(product -> new ProductInfoDto(product.getId(), product.getName(), product.getAmount(),
                        product.getPrice()))
                .collect(Collectors.toList()));
        return orderInfoDto;
    }

    public static OrderSummary toOrderSummary(OrderInfoDto orderInfoDto) {
        final OrderSummary order = new OrderSummary();
        order.setOrderNumber(orderInfoDto.getOrderNumber());
        order.setOrderDate(orderInfoDto.getOrderDate());
        order.setDeliveryAddress(order.getDeliveryAddress());
        order.setOrderStatus(orderInfoDto.getOrderStatus());
        order.setProducts(orderInfoDto.getProductInfoDtos()
                .stream()
                .map(productInfoDto -> new OrderedProduct(productInfoDto.getId(),
                        productInfoDto.getName(), productInfoDto.getPrice(),
                        productInfoDto.getAmount(), order))
                .collect(Collectors.toList()));
        return order;
    }

}
