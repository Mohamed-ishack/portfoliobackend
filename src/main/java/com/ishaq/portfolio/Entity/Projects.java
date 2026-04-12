package com.ishaq.portfolio.Entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Projects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String category;  // "fullstack", "frontend", "backend"
    private String description;
    private String tech;      // stored as "React,Node.js,MongoDB"
    private String image;
    private String github;
    private String demo;
}
