package com.ishaq.portfolio.Controller;

import com.ishaq.portfolio.Entity.Admin;
import com.ishaq.portfolio.Repository.AdminRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")
public class AdminController {

    private final AdminRepository adminRepository;

    public AdminController(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
        String username = body.get("username");
        String password = body.get("password");

        Optional<Admin> admin = adminRepository
                .findByUsernameAndPassword(username, password);

        if (admin.isPresent()) {
            return ResponseEntity.ok(Map.of("success", true, "message", "Login successful"));
        } else {
            return ResponseEntity.status(401)
                    .body(Map.of("success", false, "message", "Invalid credentials"));
        }
    }
}
