package com.ishaq.portfolio.Dto;

import java.util.List;

public class SkillCategoryDTO {

    private String title;
    private List<SkillDTO> skills;

    public SkillCategoryDTO(String title, List<SkillDTO> skills) {
        this.title = title;
        this.skills = skills;
    }

    public String getTitle() { return title; }
    public List<SkillDTO> getSkills() { return skills; }

    // Inner DTO for each skill
    public static class SkillDTO {
        private Long id;
        private String name;
        private String icon;
        private int level;

        public SkillDTO(Long id, String name, String icon, int level) {
            this.id = id;
            this.name = name;
            this.icon = icon;
            this.level = level;
        }

        public Long getId() { return id; }
        public String getName() { return name; }
        public String getIcon() { return icon; }
        public int getLevel() { return level; }
    }
}
