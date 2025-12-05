package com.innowise.orderservice.mapper;

import com.innowise.orderservice.dto.OrderCreateRequest;
import com.innowise.orderservice.dto.OrderResponse;
import com.innowise.orderservice.dto.UserResponse;
import com.innowise.orderservice.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {OrderItemMapper.class})
public interface OrderMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    Order toEntity(OrderCreateRequest request);

    @Mapping(target = "id", source = "order.id")
    @Mapping(target = "userResponse", source = "user")
    @Mapping(target = "userId", source = "order.userId")
    OrderResponse toResponse(Order order, UserResponse user);
}
