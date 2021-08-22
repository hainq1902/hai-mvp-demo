package com.mvp.order.controller;


import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mvp.order.dto.OrderInfoDto;

@RestController
public class OrderQueryController {

    @GetMapping("/orders/{orderNumber}")
    public EntityModel<OrderInfoDto> get(@PathVariable String orderNumber) {
        return EntityModel.of(new OrderInfoDto());
    }
}
