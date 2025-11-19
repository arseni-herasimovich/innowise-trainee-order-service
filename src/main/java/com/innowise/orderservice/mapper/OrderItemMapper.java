package com.innowise.orderservice.mapper;

import com.innowise.orderservice.dto.OrderItemRequest;
import com.innowise.orderservice.dto.OrderItemResponse;
import com.innowise.orderservice.entity.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderItemMapper {
    OrderItemResponse toResponse(OrderItem orderItem);
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "order", ignore = true)
    @Mapping(target = "item", ignore = true)
    OrderItem toEntity(OrderItemRequest orderItemRequest);
}
