package com.TrollMarket.TrollMarket.Controllers;

import com.TrollMarket.TrollMarket.Dto.ProfileAddBalanceDto;
import com.TrollMarket.TrollMarket.Services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("profile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping("index")
    public String index(Model model) {
        model.addAttribute("historyPurcase", profileService.getHistoryPurcase());
        model.addAttribute("profile", profileService.getProfileUserLogin());
        return "Profile/profile-index";
    }

    @GetMapping
    private String update(@RequestParam (required = false) Long id, Model model) {
        model.addAttribute("profile", profileService.getProfileUserLogin());
        return "Profile/profile-index";
    }

    @PostMapping("addBalance")
    public String updateBalance(@Valid ProfileAddBalanceDto profileAddBalanceDto,
                         BindingResult bindingResult,
                         Model model) {
        model.addAttribute("profile/addBalance", profileService.getProfileUserLogin());
        if (bindingResult.hasErrors()) {
            return update(profileAddBalanceDto.getId(), model);
        }
        profileService.saveBalance(profileAddBalanceDto);
        return "redirect:/profile/index";
    }




}
