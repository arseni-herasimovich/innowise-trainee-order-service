package com.innowise.orderservice.dto;

import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

public record OrderUpdateRequest(
        @NotNull(message = "Order items is required")
        List<OrderItemRequest> orderItems
) {
}
