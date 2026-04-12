package com.ishaq.portfolio.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String role;

    @Column(length = 1000)
    private String description;

    private String profileImage;
    private int experienceYears;
    private int projectsDone;

    private String techStack; // store as comma separated
}
