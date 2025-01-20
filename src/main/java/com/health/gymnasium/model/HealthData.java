package com.health.gymnasium.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "health_condition")
public class HealthData {
    @Id
    private String id;
    private String name;
    private int age;
    private String gender;
    private Address address;
    private List<MedicalHistory> medicalHistory;
    private String lastVisit;
}
