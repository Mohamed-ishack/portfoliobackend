package com.ishaq.portfolio.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Skills {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String icon;     // e.g. "React", "Node.js"
    private int level;       // e.g. 90
    private String category; // "Frontend", "Backend", "Database"

}