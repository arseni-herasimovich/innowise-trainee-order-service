package com.innowise.orderservice.service;

import com.innowise.orderservice.dto.OrderItemRequest;
import com.innowise.orderservice.entity.OrderItem;

public interface OrderItemService {
    OrderItem create(OrderItemRequest request);
}
