package com.wasap2.msmessages.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String text;
    private LocalDateTime timestamp;

    public Message(Long userId, String text) {
        this.userId = userId;
        this.text = text;
        this.timestamp = LocalDateTime.now();
    }
}