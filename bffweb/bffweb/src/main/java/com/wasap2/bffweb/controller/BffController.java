package com.wasap2.bffweb.controller;

import com.wasap2.bffweb.dto.DashboardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/chat")
@CrossOrigin(origins = "*") // permite conexion desde cualquier origen (frontend)
public class BffController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/dashboard")
    public DashboardDTO getDashboard() {
        DashboardDTO dashboard = new DashboardDTO();
        
        // llama a ambos microservicios (orquestacion)
        try {
            Object user = restTemplate.getForObject(
            "http://localhost:8081/users/1", Object.class);
            dashboard.setUserProfile(user);
        } catch (Exception e) {
            dashboard.setUserProfile("Usuario no disponible");
        }

        try {
            List<Object> messages = restTemplate.exchange(
                "http://localhost:8082/messages",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Object>>() {}
            ).getBody();
            dashboard.setRecentMessages(messages);
        } catch (Exception e) {
            dashboard.setRecentMessages(null);
        }

        return dashboard;
    }

    @PostMapping("/send")
    public Object sendMessage(@RequestBody Object messageData) {
        try {
            // reenvia el mensaje al microservicio de mensajes (orquestacion)
            return restTemplate.postForObject("http://localhost:8082/messages", messageData, Object.class);
        } catch (Exception e) {
            return "Error al enviar mensaje a través del BFF";
        }
    }
}