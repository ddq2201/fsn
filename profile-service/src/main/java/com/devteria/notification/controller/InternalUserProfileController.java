package com.devteria.notification.controller;

import com.devteria.notification.dto.ApiResponse;
import org.springframework.web.bind.annotation.*;

import com.devteria.notification.dto.request.ProfileCreationRequest;
import com.devteria.notification.dto.response.UserProfileResponse;
import com.devteria.notification.service.UserProfileService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class InternalUserProfileController {
    UserProfileService userProfileService;

    @PostMapping("/internal/users")
    UserProfileResponse createProfile(@RequestBody ProfileCreationRequest request) {
        return userProfileService.createProfile(request);
    }

    @GetMapping("/internal/users/{userId}")
    ApiResponse<UserProfileResponse> getProfile(@PathVariable String userId) {
        return ApiResponse.<UserProfileResponse>builder()
                .result(userProfileService.getByUserId(userId))
                .build();
    }
}
