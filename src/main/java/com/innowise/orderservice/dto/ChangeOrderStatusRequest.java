package com.innowise.orderservice.dto;

import com.innowise.orderservice.enums.OrderStatus;
import jakarta.validation.constraints.NotNull;

public record ChangeOrderStatusRequest(
        @NotNull
        OrderStatus status
) {
}
