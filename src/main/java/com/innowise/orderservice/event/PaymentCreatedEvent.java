package com.innowise.orderservice.event;

import com.innowise.orderservice.enums.PaymentStatus;

import java.util.UUID;

public record PaymentCreatedEvent(
        UUID orderId,
        PaymentStatus status
) {}
