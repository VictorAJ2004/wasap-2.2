package com.wasap2.bffweb.dto;

import lombok.Data;
import java.util.List;

@Data
public class DashboardDTO {
    private Object userProfile; // Datos de msuser
    private List<Object> recentMessages; // Datos de msmessages
}