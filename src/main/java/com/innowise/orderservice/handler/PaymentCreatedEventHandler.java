package com.innowise.orderservice.handler;

import com.innowise.orderservice.dto.ChangeOrderStatusRequest;
import com.innowise.orderservice.enums.OrderStatus;
import com.innowise.orderservice.enums.PaymentStatus;
import com.innowise.orderservice.event.PaymentCreatedEvent;
import com.innowise.orderservice.exception.NotRetryableException;
import com.innowise.orderservice.exception.OrderNotFoundException;
import com.innowise.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentCreatedEventHandler {

    private final OrderService orderService;

    @KafkaListener(topics = "PAYMENT_CREATED")
    public void handle(PaymentCreatedEvent event) {
        if (event.status() == PaymentStatus.PAID) {
            try {
                orderService.changeStatus(event.orderId(), new ChangeOrderStatusRequest(OrderStatus.PAID));
            } catch (OrderNotFoundException e) {
                throw new NotRetryableException(e);
            }
        }
    }
}
