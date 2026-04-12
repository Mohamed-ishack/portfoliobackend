package com.ishaq.portfolio.Controller;

import com.ishaq.portfolio.Entity.About;
import com.ishaq.portfolio.Repository.AboutRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/about")
@CrossOrigin("http://localhost:5173")
public class AboutController {
    @Autowired
    public AboutRepo repository;

    @GetMapping
    public About getAbout() {
        return repository.findById(1L).orElse(null);
    }

    // ✅ CREATE (first time)
    @PostMapping
    public About create(@RequestBody About about) {
        return repository.save(about);
    }

    // ✅ UPDATE
    @PutMapping("/{id}")
    public About update(@PathVariable Long id, @RequestBody About about) {
        about.setId(id);
        return repository.save(about);
    }
}
