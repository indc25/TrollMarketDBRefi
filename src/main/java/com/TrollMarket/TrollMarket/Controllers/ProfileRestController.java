package com.TrollMarket.TrollMarket.Controllers;

import com.TrollMarket.TrollMarket.Dto.Profile.ProfileBalanceDto;
import com.TrollMarket.TrollMarket.Dto.ProfileAddBalanceDto;
import com.TrollMarket.TrollMarket.Dto.ProfileDto;
import com.TrollMarket.TrollMarket.Rest.RestResponse;
import com.TrollMarket.TrollMarket.Services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("api/profile")
public class ProfileRestController {

    private ProfileService profileService;

    @Autowired
    public ProfileRestController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/find-all")
    public List<ProfileDto> findAllDto() {
        return profileService.findAllProfile();
    }

    @GetMapping("/find-by-id/{id}")
    public ProfileDto findByIdDto(@PathVariable Long id) {
        return profileService.findByIdProfile(id);
    }

    @PutMapping("/addBalance")
    public ResponseEntity<RestResponse<ProfileBalanceDto>> addBalance(@RequestBody ProfileAddBalanceDto dto){
        return new ResponseEntity<>(
                new RestResponse<>(
                        profileService.updateBalanceProfile(dto),
                        "Sukses Menambahkan Balance",
                        HttpStatus.ACCEPTED.value()),
                HttpStatus.ACCEPTED
        );
    }
}
