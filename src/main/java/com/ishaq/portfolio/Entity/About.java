package com.ishaq.portfolio.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class About {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 2000)
    private String description;   // full paragraph

    private String name;
    private String email;
    private String location;
    private String experience;

    private String profileImage;

    private String quote;
    private String quoteAuthor;

    // stats (store as string)
    private String projects;
    private String clients;
    private String years;
    private String coffee;
}