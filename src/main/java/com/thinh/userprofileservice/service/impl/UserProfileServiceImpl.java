package com.thinh.userprofileservice.service.impl;

import com.thinh.userprofileservice.dto.UserProfileDto;
import com.thinh.userprofileservice.entity.UserProfile;
import com.thinh.userprofileservice.exception.ResourceNotFoundException;
import com.thinh.userprofileservice.repository.UserProfileRepository;
import com.thinh.userprofileservice.service.UserProfileService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    private ModelMapper modelMapper;

    @Override
    public UserProfileDto getUserProfile(long id) {
        UserProfile userProfile = userProfileRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User Profile", "id", id)
        );
        return modelMapper.map(userProfile, UserProfileDto.class);
    }

    @Override
    public UserProfileDto addUserProfile(UserProfileDto userProfileDto) {
        UserProfile userProfileSaved = userProfileRepository.save(modelMapper.map(userProfileDto, UserProfile.class));
        return modelMapper.map(userProfileSaved, UserProfileDto.class);
    }
}
