package com.TrollMarket.TrollMarket.Services;

import com.TrollMarket.TrollMarket.Dto.ProfileDto;
import com.TrollMarket.TrollMarket.Dto.PurchaseHistories.HistoryPurcaseGridDto;
import com.TrollMarket.TrollMarket.Dto.User.LoginDto;
import com.TrollMarket.TrollMarket.Models.Profile;
import com.TrollMarket.TrollMarket.Repositories.ProfileRepository;
import com.TrollMarket.TrollMarket.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProfileService {

    private final ProfileRepository profileRepositories;
    private final UserRepository userRepository;

    @Autowired
    public ProfileService(ProfileRepository profileRepositories, UserRepository userRepository) {
        this.profileRepositories = profileRepositories;
        this.userRepository = userRepository;
    }

    public List<ProfileDto> findAllProfile() {
        List<Profile> profileList = profileRepositories.findAll();
        return profileList.stream()
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
    }

    public ProfileDto findByIdProfile(Long id) {

            Profile profile = profileRepositories.findById(id).orElse(null);
        return new ProfileDto(
                profile.getId(),
                profile.getUser().getRoleID().getRoleName(),
                profile.getFullName(),
                profile.getGender(),
                profile.getBirthDate(),
                profile.getPhone(),
                profile.getAddress(),
                profile.getRegisterDate(),
                profile.getBalance().getBalance());
    }

    public ProfileDto getProfileUserLogin() {
        Optional<LoginDto> user = userRepository.findByUsername(getUserLogin());
        Profile profile = profileRepositories.getById(user.get().getId());

        return new ProfileDto(
                profile.getId(),
                profile.getUser().getRoleID().getRoleName(),
                profile.getFullName(),
                profile.getGender(),
                profile.getBirthDate(),
                profile.getPhone(),
                profile.getAddress(),
                profile.getRegisterDate(),
                profile.getBalance().getBalance());
    }


    public List<HistoryPurcaseGridDto> getHistoryPurcase() {
        Optional<LoginDto> user = userRepository.findByUsername(getUserLogin());
        Profile profile = profileRepositories.getById(user.get().getId());

        return profile.getHistories().stream()
                .map(history -> new HistoryPurcaseGridDto(
                        history.getHistoryDate().toString(),
                        history.getProductID().getProductName(),
                        history.getQuantity(),
                        history.getShipVia().getCompanyName(),
                        history.getTotalPrice()
                ))
                .toList();
    }

    private String getUserLogin() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        System.out.println(currentPrincipalName);
        return currentPrincipalName;
    }
}
