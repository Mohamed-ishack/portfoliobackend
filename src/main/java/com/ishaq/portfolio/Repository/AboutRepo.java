package com.ishaq.portfolio.Repository;

import com.ishaq.portfolio.Entity.About;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AboutRepo extends JpaRepository<About, Long> {
}
