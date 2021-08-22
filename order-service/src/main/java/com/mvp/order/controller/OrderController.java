package com.mvp.order.controller;

import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.mvp.order.dto.OrderInfoDto;
import com.mvp.order.dto.ProductInfoDto;
import com.mvp.order.service.OrderManagementService;
import com.mvp.order.service.OrderQueryService;

@RestController
public class OrderController {
    private final OrderManagementService orderManagementService;
    private final OrderQueryService orderQueryService;

    public OrderController(OrderManagementService orderManagementService, OrderQueryService orderQueryService) {
        this.orderManagementService = orderManagementService;
        this.orderQueryService = orderQueryService;
    }

    @PostMapping("/orders/{orderNumber}")
    public ResponseEntity<?> addItem(@PathVariable String orderNumber, @RequestBody ProductInfoDto productInfoDto) {
        final OrderInfoDto orderInfoDto = orderManagementService.addProductInfo(orderNumber, productInfoDto);
        return generateOrderResponse(orderInfoDto);
    }

    @PostMapping("/orders")
    public ResponseEntity<?> addNewOrder(@RequestBody ProductInfoDto productInfoDto) {
        final String orderNumber = orderManagementService.createOrder(productInfoDto);
        return generateOrderResponse(orderQueryService.findByOrderNumber(orderNumber));
    }

    private ResponseEntity<EntityModel<OrderInfoDto>> generateOrderResponse(OrderInfoDto orderInfoDto) {
        final EntityModel<OrderInfoDto> entityModel =
                EntityModel.of(orderInfoDto,
                        linkTo(methodOn(OrderQueryController.class).get(orderInfoDto.getOrderNumber()))
                                .withRel("orders"));
        return ResponseEntity.created(entityModel.getRequiredLink("orders").toUri()).body(entityModel);
    }
}
