package com.devteria.notification.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.devteria.notification.dto.ApiResponse;
import com.devteria.notification.dto.response.UserProfileResponse;
import com.devteria.notification.service.UserProfileService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserProfileController {
    UserProfileService userProfileService;

    @GetMapping("/users/{profileId}")
    UserProfileResponse getProfile(@PathVariable String profileId) {

        return userProfileService.getProfile(profileId);
    }

    @GetMapping("/users")
    ApiResponse<List<UserProfileResponse>> getAllProfiles() {
        return ApiResponse.<List<UserProfileResponse>>builder()
                .result(userProfileService.getAllProfiles())
                .build();
    }

    @DeleteMapping("/users/delete/{profileId}")
    public ResponseEntity<String> deleteProfile(@PathVariable String profileId) {
        userProfileService.deleteProfile(profileId);
        return ResponseEntity.ok().body("SUCCESS"); // Return 204 No Content on successful deletion
    }
}
