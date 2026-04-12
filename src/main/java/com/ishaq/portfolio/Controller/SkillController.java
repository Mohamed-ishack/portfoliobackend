package com.ishaq.portfolio.Controller;

import com.ishaq.portfolio.Dto.SkillCategoryDTO;
import com.ishaq.portfolio.Entity.Skills;
import com.ishaq.portfolio.Repository.SkillsRepo;
import com.ishaq.portfolio.service.SkillService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api")
public class SkillController {

    private final SkillService skillService;
    private final SkillsRepo skillRepository;

    // ✅ inject both service and repository
    public SkillController(SkillService skillService, SkillsRepo skillRepository) {
        this.skillService    = skillService;
        this.skillRepository = skillRepository;
    }

    // GET /api/skills
    @GetMapping("/skills")
    public List<SkillCategoryDTO> getSkills() {
        return skillService.getGroupedSkills();
    }

    // POST /api/skills
    @PostMapping("/skills")
    public ResponseEntity<?> addSkill(@RequestBody Skills skill) {
        return ResponseEntity.ok(skillRepository.save(skill));
    }

    // PUT /api/skills/{id}
    @PutMapping("/skills/{id}")
    public ResponseEntity<?> updateSkill(@PathVariable Long id, @RequestBody Skills skill) {
        skill.setId(id);                              // ✅ Skills not Skill
        return ResponseEntity.ok(skillRepository.save(skill));
    }

    // DELETE /api/skills/{id}
    @DeleteMapping("/skills/{id}")
    public ResponseEntity<?> deleteSkill(@PathVariable Long id) {
        skillRepository.deleteById(id);
        return ResponseEntity.ok(Map.of("message", "Deleted successfully"));
    }
}