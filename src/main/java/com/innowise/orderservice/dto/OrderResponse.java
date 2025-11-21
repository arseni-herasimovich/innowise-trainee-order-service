package com.innowise.orderservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.innowise.orderservice.enums.OrderStatus;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record OrderResponse(
        UUID id,
        UUID userId,
        OrderStatus status,
        LocalDate creationDate,
        List<OrderItemResponse> orderItems,
        @JsonProperty("userData")
        UserResponse userResponse
) {
}
