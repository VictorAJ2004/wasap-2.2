package com.wasap2.bffweb;

import static org.assertj.core.api.Assertions.assertThat;
import com.wasap2.bffweb.controller.BffController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class BffwebApplicationTests {

    @Autowired
    private BffController bffController;

    @Autowired
    private RestTemplate restTemplate;

    @Test
    void contextLoads() {
        // verifica que el controlador bff esté disponible
        assertThat(bffController).isNotNull();
    }

    @Test
    void restTemplateIsConfigured() {
        // verifica que la configuración de RestTemplate sea válida
        assertThat(restTemplate).isNotNull();
    }
}