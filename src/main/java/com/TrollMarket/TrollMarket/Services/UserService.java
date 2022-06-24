package com.TrollMarket.TrollMarket.Services;

import com.TrollMarket.TrollMarket.Configs.AppSecurityConfig;
import com.TrollMarket.TrollMarket.Dto.Role.RoleDropdownDto;
import com.TrollMarket.TrollMarket.Dto.User.RegisterDTO;
import com.TrollMarket.TrollMarket.Models.Profile;
import com.TrollMarket.TrollMarket.Models.Role;
import com.TrollMarket.TrollMarket.Models.User;
import com.TrollMarket.TrollMarket.Repositories.ProfileRepository;
import com.TrollMarket.TrollMarket.Repositories.RoleRepository;
import com.TrollMarket.TrollMarket.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private ProfileRepository profileRepository;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public List<RoleDropdownDto> getRoleDropdown() {
        return roleRepository.findAll().stream()
                .map(role -> new RoleDropdownDto(role.getId(), role.getRoleName()))
                .collect(Collectors.toList());
    }

    public void registerAccount(RegisterDTO dto) {
        Role role = roleRepository.findById(dto.getRole()).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Role not found"));
        PasswordEncoder passwordEncoder = AppSecurityConfig.passwordEncoder();
        String hashPassword = passwordEncoder.encode(dto.getPassword());
        userRepository.save(new User(
                dto.getUsername(),
                hashPassword,
                role,
                true));
    }

}