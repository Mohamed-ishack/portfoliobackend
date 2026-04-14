package com.ishaq.portfolio.Controller;

import com.ishaq.portfolio.Entity.About;
import com.ishaq.portfolio.Repository.AboutRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/about")
@CrossOrigin("http://localhost:5173")
public class AboutController {
    @Autowired
    public AboutRepo repository;

    @GetMapping
    public ResponseEntity<About> getAbout() {
        List<About> list = repository.findAll();
        if (list.isEmpty()) {
            return ResponseEntity.ok(new About());
        }
        return ResponseEntity.ok(list.get(0));
    }

    // ✅ CREATE (first time)
    @PostMapping
    public ResponseEntity<About> create(@RequestBody About about) {
        return ResponseEntity.ok(repository.save(about));
    }

    // ✅ UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<About> update(@PathVariable Long id, @RequestBody About about) {
        about.setId(id);
        return ResponseEntity.ok(repository.save(about));
    }
}
