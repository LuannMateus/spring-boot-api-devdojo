package com.luanmateus.springessentials.repository;

import com.luanmateus.springessentials.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
