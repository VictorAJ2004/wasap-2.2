package com.wasap2.msuser.repository;

import com.wasap2.msuser.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> { }