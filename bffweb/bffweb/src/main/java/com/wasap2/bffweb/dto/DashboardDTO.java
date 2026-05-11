package com.wasap2.bffweb.dto;

import lombok.Data;
import java.util.List;

@Data
public class DashboardDTO {
    private Object userProfile; 
    private List<Object> recentMessages; 
}