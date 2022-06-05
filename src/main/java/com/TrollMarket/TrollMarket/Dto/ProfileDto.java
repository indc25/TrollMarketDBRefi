package com.TrollMarket.TrollMarket.Dto;

import com.TrollMarket.TrollMarket.Models.Profile;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    private final BigDecimal balance;

    public static List<ProfileDto> toList (List<Profile> profiles){
        List<ProfileDto> result = new ArrayList<>();

        for (Profile profile : profiles){
            result.add(new ProfileDto(
                    profile.getUser().getId(),
                    profile.getUser().getRoleID().getRoleName(),
                    profile.getFullName(),
                    profile.getGender(),
                    profile.getBirthDate(),
                    profile.getPhone(),
                    profile.getAddress(),
                    profile.getRegisterDate(),
                    profile.getBalance().getBalance()));
        }
        return result;
    }
}
