package com.TrollMarket.TrollMarket.Services;

import com.TrollMarket.TrollMarket.Dto.Profile.ProfileBalanceDto;
import com.TrollMarket.TrollMarket.Dto.ProfileAddBalanceDto;
import com.TrollMarket.TrollMarket.Dto.ProfileDto;
import com.TrollMarket.TrollMarket.Dto.PurchaseHistories.HistoryPurcaseGridDto;
import com.TrollMarket.TrollMarket.Dto.User.LoginDto;
import com.TrollMarket.TrollMarket.Models.Balance;
import com.TrollMarket.TrollMarket.Models.Profile;
import com.TrollMarket.TrollMarket.Repositories.BalanceRepository;
import com.TrollMarket.TrollMarket.Repositories.ProfileRepository;
import com.TrollMarket.TrollMarket.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class ProfileService {

    private final ProfileRepository profileRepositories;
    private final UserRepository userRepository;
    private final BalanceRepository balanceRepository;
    NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));

    @Autowired
    public ProfileService(ProfileRepository profileRepositories, UserRepository userRepository, BalanceRepository balanceRepository) {
        this.profileRepositories = profileRepositories;
        this.userRepository = userRepository;
        this.balanceRepository = balanceRepository;
    }

    public List<ProfileDto> findAllProfile() {
        List<Profile> profileList = profileRepositories.findAll();

        return ProfileDto.toList(profileList);
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
                currencyInstance.format(profile.getBalance().getBalance()));
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
                currencyInstance.format(profile.getBalance().getBalance()));
    }


    public List<HistoryPurcaseGridDto> getHistoryPurcase() {
        Optional<LoginDto> user = userRepository.findByUsername(getUserLogin());
        Profile profile = profileRepositories.getById(user.get().getId());
        //create dateTimeFormatter indonesia
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", new Locale("id", "ID"));
        //create format currency indonesia
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));

        return profile.getHistories().stream()
                .map(history -> new HistoryPurcaseGridDto(
                        history.getHistoryDate().format(timeFormatter),
                        history.getProductID().getProductName(),
                        history.getQuantity(),
                        history.getShipVia().getCompanyName(),
                        currencyInstance.format(history.getTotalPrice())
                ))
                .toList();
    }

    private String getUserLogin() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        System.out.println(currentPrincipalName);
        return currentPrincipalName;
    }

    public void saveBalance(ProfileAddBalanceDto profileAddBalanceDto){
        Balance balance = balanceRepository.getById(profileAddBalanceDto.getId());
        balance.setBalance(balance.getBalance().add(profileAddBalanceDto.getBalance()));
        balanceRepository.save(balance);
    }

    public ProfileBalanceDto updateBalanceProfile(ProfileAddBalanceDto dto){
        Balance balance = balanceRepository.getById(dto.getId());
        balance.setBalance(balance.getBalance().add(dto.getBalance()));
        balanceRepository.save(balance);
        return ProfileBalanceDto.set(balance);
    }
}
