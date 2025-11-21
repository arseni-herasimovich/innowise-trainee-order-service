package com.innowise.orderservice.mapper;

import com.innowise.orderservice.dto.ItemCreateRequest;
import com.innowise.orderservice.dto.ItemResponse;
import com.innowise.orderservice.dto.ItemUpdateRequest;
import com.innowise.orderservice.entity.Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ItemMapper {
    @Mapping(target = "id", ignore = true)
    Item toEntity(ItemCreateRequest itemCreateRequest);

    ItemResponse toResponse(Item item);

    @Mapping(target = "id", ignore = true)
    void update(ItemUpdateRequest itemUpdateRequest, @MappingTarget Item item);
}
