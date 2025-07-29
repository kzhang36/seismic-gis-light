package com.example.seismicgis.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Earthquake {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double latitude;
    private double longitude;
    private double magnitude;
    private double depth;
    private String location;
    private LocalDateTime timestamp;

    // Getters and setters omitted for brevity
}
