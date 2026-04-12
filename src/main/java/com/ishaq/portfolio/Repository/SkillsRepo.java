package com.ishaq.portfolio.Repository;

import com.ishaq.portfolio.Entity.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SkillsRepo extends JpaRepository<Skills, Long> {
    List<Skills> findByCategory(String category);
}
