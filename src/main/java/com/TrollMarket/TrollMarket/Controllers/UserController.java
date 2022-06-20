package com.TrollMarket.TrollMarket.Controllers;

import com.TrollMarket.TrollMarket.Dto.Role.RoleDropdownDto;
import com.TrollMarket.TrollMarket.Dto.User.RegisterDTO;
import com.TrollMarket.TrollMarket.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

//    @GetMapping("login-form")
//    public String loginForm(Model model) {
//        return "account/login-form";
//    }
    @GetMapping("login-form")
    public String loginForm(Model model) {
        return "login-layout";
    }

    @GetMapping("access-denied")
    public String accessDenied() {
        return "account/access-denied";
    }

    @GetMapping("register-form")
    public String registerForm(Model model) {
        RegisterDTO dto = new RegisterDTO();
        List<RoleDropdownDto> roleDropdown = userService.getRoleDropdown();
        model.addAttribute("roleDropdown", roleDropdown);
        model.addAttribute("account", dto);
        return "account/register-form";
    }

    @PostMapping("register")
    public String register(@Valid @ModelAttribute("user") RegisterDTO dto,
                           BindingResult bindingResult,
                           Model model) {
        if (bindingResult.hasErrors()) {
            List<RoleDropdownDto> roleDropdown = userService.getRoleDropdown();
            model.addAttribute("account", dto);
            model.addAttribute("roleDropdown", roleDropdown);
            return "user/register-form";
        }
        userService.registerAccount(dto);
        return "redirect:/login";
    }
}
