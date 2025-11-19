package com.innowise.orderservice.service;

import com.innowise.orderservice.dto.UserResponse;

import java.util.UUID;

public interface UserDataService {

    UserResponse fetchUserData(UUID userId);
}
