package com.wasap2.msmessages.controller;

import com.wasap2.msmessages.model.Message;
import com.wasap2.msmessages.repository.MessageRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {
    @Autowired
    private MessageRepository repository;

    @PostConstruct
    public void init() {
        repository.save(new Message(1L, "Hola desde el microservicio de mensajes"));
    }

    @GetMapping
    public List<Message> getAll() {
        return repository.findAll();
    }
}