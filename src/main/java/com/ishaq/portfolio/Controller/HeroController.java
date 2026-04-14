package com.ishaq.portfolio.Controller;

import com.ishaq.portfolio.Entity.Hero;
import com.ishaq.portfolio.Repository.HeroRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hero")
@CrossOrigin(origins = "*")
public class HeroController {

    @Autowired
    public HeroRepo repository;

    // GET /api/hero
    @GetMapping
    public ResponseEntity<?> getHero() {
        List<Hero> list = repository.findAll();
        if (list.isEmpty()) {
            return ResponseEntity.ok(new Hero()); // Return empty object instead of 404
        }
        return ResponseEntity.ok(list.get(0));
    }

    // PUT /api/hero/{id}
    @PutMapping("/{id}")
    public ResponseEntity<?> updateHero(@PathVariable Long id, @RequestBody Hero hero) {
        hero.setId(id);
        return ResponseEntity.ok(repository.save(hero));
    }

    // POST /api/hero
    @PostMapping
    public ResponseEntity<?> createHero(@RequestBody Hero hero) {
        return ResponseEntity.ok(repository.save(hero));
    }
}