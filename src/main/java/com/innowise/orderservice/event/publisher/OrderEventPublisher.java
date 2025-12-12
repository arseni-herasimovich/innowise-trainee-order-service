package com.innowise.orderservice.event.publisher;

import com.innowise.orderservice.event.OrderCreatedEvent;

public interface OrderEventPublisher {
    void publishOrderCreated(OrderCreatedEvent event);
}
