package com.innowise.orderservice.client;

import com.innowise.orderservice.dto.ApiResponse;
import com.innowise.orderservice.dto.ValidateTokenRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "auth-service")
public interface AuthServiceClient {

    @PostMapping("/api/v1/auth/validate")
    ApiResponse<Boolean> validate(ValidateTokenRequest request);
}
