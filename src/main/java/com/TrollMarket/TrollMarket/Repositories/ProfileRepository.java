package com.TrollMarket.TrollMarket.Repositories;

import com.TrollMarket.TrollMarket.Models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}