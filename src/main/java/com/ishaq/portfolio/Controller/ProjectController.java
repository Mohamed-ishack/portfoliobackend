package com.ishaq.portfolio.Controller;

import com.ishaq.portfolio.Dto.ProjectDTO;
import com.ishaq.portfolio.Entity.Projects;
import com.ishaq.portfolio.Repository.ProjectRepository;
import com.ishaq.portfolio.service.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api")
public class ProjectController {

    private final ProjectService projectService;
    private final ProjectRepository projectRepository;

    // ✅ inject both service and repository
    public ProjectController(ProjectService projectService, ProjectRepository projectRepository) {
        this.projectService   = projectService;
        this.projectRepository = projectRepository;
    }

    // GET /api/projects
    @GetMapping("/projects")
    public List<ProjectDTO> getProjects() {
        return projectService.getAllProjects();
    }

    // POST /api/projects
    @PostMapping("/projects")
    public ResponseEntity<?> addProject(@RequestBody Projects project) {
        return ResponseEntity.ok(projectRepository.save(project));
    }

    // PUT /api/projects/{id}
    @PutMapping("/projects/{id}")
    public ResponseEntity<?> updateProject(@PathVariable Long id, @RequestBody Projects project) {
        project.setId(id);
        return ResponseEntity.ok(projectRepository.save(project));
    }

    // DELETE /api/projects/{id}
    @DeleteMapping("/projects/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable Long id) {
        projectRepository.deleteById(id);
        return ResponseEntity.ok(Map.of("message", "Deleted successfully"));
    }
}