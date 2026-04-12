package com.ishaq.portfolio.Dto;

import java.util.Arrays;
import java.util.List;

public class ProjectDTO {

    private Long id;
    private String title;
    private String category;
    private String description;
    private List<String> tech;   // ✅ List instead of comma string
    private String image;
    private String github;
    private String demo;

    public ProjectDTO(Long id, String title, String category,
                      String description, String tech,
                      String image, String github, String demo) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.description = description;
        this.tech = Arrays.stream(tech.split(","))
                .map(String::trim)
                .toList();   // ✅ "React,Node.js" → ["React", "Node.js"]
        this.image = image;
        this.github = github;
        this.demo = demo;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public String getDescription() { return description; }
    public List<String> getTech() { return tech; }
    public String getImage() { return image; }
    public String getGithub() { return github; }
    public String getDemo() { return demo; }
}