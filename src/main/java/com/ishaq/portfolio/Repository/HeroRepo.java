package com.ishaq.portfolio.Repository;

import com.ishaq.portfolio.Entity.Hero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroRepo extends JpaRepository<Hero, Long> {
}
