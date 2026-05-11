package com.wasap2.msmessages.repository;

import com.wasap2.msmessages.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    // Aquí implementas el Patrón Repository solicitado en la rúbrica
}