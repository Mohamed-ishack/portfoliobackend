package com.ishaq.portfolio.service;
import com.ishaq.portfolio.Dto.SkillCategoryDTO;
import com.ishaq.portfolio.Entity.Skills;
import com.ishaq.portfolio.Repository.SkillsRepo;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SkillService {

    private final SkillsRepo skillRepository;

    public SkillService(SkillsRepo skillRepository) {
        this.skillRepository = skillRepository;
    }

    public List<SkillCategoryDTO> getGroupedSkills() {
        List<String> categories = Arrays.asList("Frontend", "Backend", "Database");

        return categories.stream()
                .map(category -> {
                    List<Skills> skills = skillRepository.findByCategory(category);
                    List<SkillCategoryDTO.SkillDTO> skillDTOs = skills.stream()
                            .map(s -> new SkillCategoryDTO.SkillDTO(s.getId(), s.getName(), s.getIcon(), s.getLevel()))
                            .collect(Collectors.toList());
                    return new SkillCategoryDTO(category, skillDTOs);
                })
                .collect(Collectors.toList());
    }
}
