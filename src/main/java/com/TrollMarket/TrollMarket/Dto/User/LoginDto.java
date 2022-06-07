package com.TrollMarket.TrollMarket.Dto.User;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginDto implements Serializable {
    private final Long id;
    private final String username;
    private final String password;
    private final Integer roleId;
    private final String roleName;
    private final Boolean enabled;
}
