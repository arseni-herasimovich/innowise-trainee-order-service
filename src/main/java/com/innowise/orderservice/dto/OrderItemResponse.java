package com.innowise.orderservice.dto;

import com.innowise.orderservice.entity.Item;

public record OrderItemResponse(
        Item item,
        Integer quantity
) {
}
