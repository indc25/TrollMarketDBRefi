package com.TrollMarket.TrollMarket.Dto.Role;

import lombok.Data;

import java.io.Serializable;

@Data
public class RoleDropdownDto implements Serializable {
    private final Integer id;
    private final String roleName;
}
