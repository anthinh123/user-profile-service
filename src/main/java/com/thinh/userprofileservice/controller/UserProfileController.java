package com.thinh.userprofileservice.controller;

import com.thinh.userprofileservice.dto.UserProfileDto;
import com.thinh.userprofileservice.service.UserProfileService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/userprofile")
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @GetMapping("{user-id}")
    public ResponseEntity<UserProfileDto> getUserProfileById(long id) {
        return new ResponseEntity<>(userProfileService.getUserProfile(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserProfileDto> saveUserProfile(@RequestBody UserProfileDto userProfileDto) {
        return new ResponseEntity<>(userProfileService.addUserProfile(userProfileDto), HttpStatus.OK);
    }
}
