package com.wasap2.msuser.controller;

import com.wasap2.msuser.model.User;
import com.wasap2.msuser.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository repository;

    @PostConstruct
    public void init() {
        repository.save(new User("Juan_Perez", "Online"));
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }
}