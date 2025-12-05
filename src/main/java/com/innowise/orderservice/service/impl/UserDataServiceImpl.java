package com.innowise.orderservice.service.impl;

import com.innowise.orderservice.client.UserServiceClient;
import com.innowise.orderservice.dto.UserResponse;
import com.innowise.orderservice.service.UserDataService;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserDataServiceImpl implements UserDataService {
    private final UserServiceClient userServiceClient;

    @Override
    public UserResponse fetchUserData(String userId) {
        try {
            log.debug("Fetching user data for user ID: {}", userId);
            var response = userServiceClient.getById(userId);
            if (response != null && response.isSuccess() && response.getData() != null) {
                log.debug("Successfully fetched user data for user ID: {}", userId);
                return response.getData();
            }
            log.debug("Fetching user data failed: {}", response);
        } catch (FeignException e) {
            log.debug("Error while fetching user info for user ID: {}", userId, e);
        }
        return null;
    }
}
