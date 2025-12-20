package com.innowise.orderservice.handler;

import com.innowise.orderservice.dto.ChangeOrderStatusRequest;
import com.innowise.orderservice.enums.OrderStatus;
import com.innowise.orderservice.enums.PaymentStatus;
import com.innowise.orderservice.event.PaymentCreatedEvent;
import com.innowise.orderservice.service.OrderService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PaymentCreatedEventHandlerTest {
    @Mock
    private OrderService orderService;

    @InjectMocks
    private PaymentCreatedEventHandler handler;

    @Test
    @DisplayName("Should change order status to PAID when status is PAID")
    void givenPAIDStatus_whenHandle_thenChangeStatusToPAID() {
        var orderId = UUID.randomUUID();
        handler.handle(new PaymentCreatedEvent(orderId, PaymentStatus.PAID));
        verify(orderService, times(1))
                .changeStatus(orderId, new ChangeOrderStatusRequest(OrderStatus.PAID));
    }

    @Test
    @DisplayName("Should not change order status to PAID when status is not PAID")
    void givenOtherStatus_whenHandle_thenDoNothing() {
        var orderId = UUID.randomUUID();
        handler.handle(new PaymentCreatedEvent(orderId, PaymentStatus.FAILED));
        verify(orderService, never())
                .changeStatus(orderId, new ChangeOrderStatusRequest(OrderStatus.PAID));
    }
}
