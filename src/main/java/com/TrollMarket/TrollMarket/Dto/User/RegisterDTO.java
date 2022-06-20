package com.TrollMarket.TrollMarket.Dto.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO implements Serializable {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Integer role;
}
