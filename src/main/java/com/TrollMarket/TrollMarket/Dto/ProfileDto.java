package com.TrollMarket.TrollMarket.Dto;

import com.TrollMarket.TrollMarket.Models.Profile;
import lombok.Data;

import javax.persistence.EntityNotFoundException;
import java.io.Serializable;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

@Data
public class ProfileDto implements Serializable {
    private final Long userId;
    private final String role;
    private final String fullName;
    private final String gender;
    private final LocalDate birthDate;
    private final String phone;
    private final String address;
    private final LocalDate registerDate;
    private final String balance;

    public static List<ProfileDto> toList(List<Profile> profileList) {
        if (profileList.isEmpty()) {
            throw new EntityNotFoundException("Data Tidak Ditemukan");
        }

        Stream<ProfileDto> result = profileList.stream().map(ProfileDto::set);
        return result.toList();
    }

    private static ProfileDto set(Profile profile) {
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        return new ProfileDto(
                profile.getId(),
                profile.getUser().getRoleID().getRoleName(),
                profile.getFullName(),
                profile.getGender(),
                profile.getBirthDate(),
                profile.getPhone(),
                profile.getAddress(),
                profile.getRegisterDate(),
                currencyInstance.format(profile.getBalance().getBalance())
        );
    }
}
