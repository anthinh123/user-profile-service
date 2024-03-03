package com.thinh.userprofileservice.service;

import com.thinh.userprofileservice.dto.UserProfileDto;
import com.thinh.userprofileservice.entity.UserProfile;

public interface UserProfileService {
    UserProfileDto getUserProfile(long id);

    UserProfileDto addUserProfile(UserProfileDto userProfileDto);
}
