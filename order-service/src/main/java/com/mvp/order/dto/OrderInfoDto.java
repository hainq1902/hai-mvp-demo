package com.mvp.order.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import com.mvp.order.repository.model.OrderStatus;

public class OrderInfoDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String orderNumber;
    private LocalDate orderDate;
    private String deliveryAddress;
    private OrderStatus orderStatus;
    private List<ProductInfoDto> productInfoDtos;

    public OrderInfoDto() {
    }

    public OrderInfoDto(String orderNumber, List<ProductInfoDto> productInfoDtos) {
        this.orderNumber = orderNumber;
        this.productInfoDtos = productInfoDtos;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public List<ProductInfoDto> getProductInfoDtos() {
        return productInfoDtos;
    }

    public void setProductInfoDtos(List<ProductInfoDto> productInfoDtos) {
        this.productInfoDtos = productInfoDtos;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
