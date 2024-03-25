package com.ilionx.demo.onetoone.repositories;

import com.ilionx.demo.onetoone.models.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
}