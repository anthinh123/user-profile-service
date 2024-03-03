package com.thinh.userprofileservice.repository;

import com.thinh.userprofileservice.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
}
