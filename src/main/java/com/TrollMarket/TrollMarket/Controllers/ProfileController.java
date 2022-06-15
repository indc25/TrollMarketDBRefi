package com.TrollMarket.TrollMarket.Controllers;

import com.TrollMarket.TrollMarket.Dto.ProfileAddBalanceDto;
import com.TrollMarket.TrollMarket.Services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("profile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping("/index")
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
    public String updateBalance(@Valid @ModelAttribute("addBalance") ProfileAddBalanceDto dto,
                         BindingResult bindingResult,
                         Model model) {
        if (bindingResult.hasErrors()) {
            return update(dto.getId(), model);
        }
        profileService.saveBalance(dto);
        return "redirect:/profile/index";
    }




}
