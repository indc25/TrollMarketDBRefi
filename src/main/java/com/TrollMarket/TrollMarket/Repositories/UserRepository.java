package com.TrollMarket.TrollMarket.Repositories;

import com.TrollMarket.TrollMarket.Dto.User.LoginDto;
import com.TrollMarket.TrollMarket.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("""
            SELECT new com.TrollMarket.TrollMarket.Dto.User.LoginDto
            (a.id, a.username, a.password, a.roleID.id, a.roleID.roleName, a.enabled)
            FROM User a
            WHERE a.username = :username
            """)
    Optional<LoginDto> findByUsername(String username);
}