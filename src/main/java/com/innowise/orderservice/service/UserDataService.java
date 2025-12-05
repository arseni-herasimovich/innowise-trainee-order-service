package com.innowise.orderservice.service;

import com.innowise.orderservice.dto.UserResponse;

public interface UserDataService {

    UserResponse fetchUserData(String userId);
}
