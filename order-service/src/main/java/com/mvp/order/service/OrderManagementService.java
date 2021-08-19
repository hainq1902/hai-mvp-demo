package com.mvp.order.service;

import com.mvp.order.dto.OrderInfoDto;
import com.mvp.order.dto.ProductInfoDto;

public interface OrderManagementService {

    String createOrder(ProductInfoDto productInfoDto);

    String generateOrderNumber();

    OrderInfoDto addProductInfo(String orderNumber, ProductInfoDto productInfoDto);
}
