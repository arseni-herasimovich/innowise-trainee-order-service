package com.innowise.orderservice.dto;

import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

public record OrderCreateRequest(
        @NotNull(message = "User ID is required")
        UUID userId,
        @NotNull(message = "Order items is required")
        List<OrderItemRequest> orderItems
) {
}
