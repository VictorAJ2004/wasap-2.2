package com.wasap2.msuser;

import static org.assertj.core.api.Assertions.assertThat;
import com.wasap2.msuser.controller.UserController;
import com.wasap2.msuser.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MsuserApplicationTests {

    @Autowired
    private UserController userController;

    @Test
    void contextLoads() {
        // verifica que el controlador cargue (Patrón Singleton)
        assertThat(userController).isNotNull();
    }

    @Test
    void testInitialUserExists() {
        // verifica que el usuario creado en @PostConstruct exista
        User user = userController.getById(1L);
        assertThat(user).isNotNull();
        assertThat(user.getUsername()).isEqualTo("Juan_Perez");
    }
}