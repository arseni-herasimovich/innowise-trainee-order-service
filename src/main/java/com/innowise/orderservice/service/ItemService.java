package com.innowise.orderservice.service;

import com.innowise.orderservice.dto.ItemCreateRequest;
import com.innowise.orderservice.dto.ItemResponse;
import com.innowise.orderservice.dto.ItemUpdateRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ItemService {
    ItemResponse create(ItemCreateRequest request);

    ItemResponse getById(UUID id);

    ItemResponse update(UUID id, ItemUpdateRequest request);

    void delete(UUID id);

    Page<ItemResponse> getAll(Pageable pageable);
}
