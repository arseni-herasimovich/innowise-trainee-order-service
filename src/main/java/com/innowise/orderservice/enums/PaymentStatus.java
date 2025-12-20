package com.innowise.orderservice.enums;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

public enum PaymentStatus {
    CREATED,
    PAID,
    FAILED,
    @JsonEnumDefaultValue
    UNKNOWN
}
