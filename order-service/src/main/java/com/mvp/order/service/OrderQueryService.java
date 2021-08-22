package com.mvp.order.service;

import com.mvp.order.dto.OrderInfoDto;

public interface OrderQueryService {
    OrderInfoDto findByOrderNumber(String orderNumber);
}
