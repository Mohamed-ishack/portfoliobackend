package com.ishaq.portfolio.service;

import com.ishaq.portfolio.Dto.ProjectDTO;
import com.ishaq.portfolio.Repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<ProjectDTO> getAllProjects() {
        return projectRepository.findAll()
                .stream()
                .map(p -> new ProjectDTO(
                        p.getId(),
                        p.getTitle(),
                        p.getCategory(),
                        p.getDescription(),
                        p.getTech(),
                        p.getImage(),
                        p.getGithub(),
                        p.getDemo()
                ))
                .collect(Collectors.toList());
    }
}
