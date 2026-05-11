package com.wasap2.msmessages;

import static org.assertj.core.api.Assertions.assertThat;
import com.wasap2.msmessages.controller.MessageController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
class MsmessagesApplicationTests {

    @Autowired
    private MessageController messageController;

    @Test
    void contextLoads() {
        assertThat(messageController).isNotNull();
    }

    @Test
    void testInitialMessagesExist() {
        // verifica que el mensaje creado en @PostConstruct exista
        List<?> messages = messageController.getAll();
        assertThat(messages).isNotEmpty();
        assertThat(messages.size()).isGreaterThanOrEqualTo(1);
    }
}