package com.TrollMarket.TrollMarket.Controllers;

import com.TrollMarket.TrollMarket.Dto.ProfileDto;
import com.TrollMarket.TrollMarket.Services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
