package com.TrollMarket.TrollMarket.Services;

import com.TrollMarket.TrollMarket.Dto.ProfileDto;
import com.TrollMarket.TrollMarket.Models.Profile;
import com.TrollMarket.TrollMarket.Repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfileService {

    private ProfileRepository profileRepositories;

    @Autowired
    public ProfileService(ProfileRepository profileRepositories) {
        this.profileRepositories = profileRepositories;
    }

    public List<ProfileDto> findAllProfile() {

        List<Profile> profileList = profileRepositories.findAll();
        List<ProfileDto> result = profileList.stream()
                .map(profile -> new ProfileDto(
                        profile.getId(),
                        profile.getUser().getRoleID().getRoleName(),
                        profile.getFullName(),
                        profile.getGender(),
                        profile.getBirthDate(),
                        profile.getPhone(),
                        profile.getAddress(),
                        profile.getRegisterDate(),
                        profile.getBalance().getBalance()
                        ))
                .collect(Collectors.toList());
        return result;
    }

    public ProfileDto findByIdProfile(Long id) {

            Profile profile = profileRepositories.findById(id).orElse(null);
            ProfileDto result = new ProfileDto(
                    profile.getId(),
                    profile.getUser().getRoleID().getRoleName(),
                    profile.getFullName(),
                    profile.getGender(),
                    profile.getBirthDate(),
                    profile.getPhone(),
                    profile.getAddress(),
                    profile.getRegisterDate(),
                    profile.getBalance().getBalance());
            return result;
    }
}
