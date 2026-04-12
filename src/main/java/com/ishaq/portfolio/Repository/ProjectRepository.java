package com.ishaq.portfolio.Repository;

import com.ishaq.portfolio.Entity.Projects;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Projects, Long> {
}