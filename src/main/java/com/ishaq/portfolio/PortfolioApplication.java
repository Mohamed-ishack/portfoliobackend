package com.ishaq.portfolio;

import com.ishaq.portfolio.Entity.Admin;
import com.ishaq.portfolio.Repository.AdminRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PortfolioApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortfolioApplication.class, args);
	}

	@Bean
	public CommandLineRunner seedData(AdminRepository adminRepository) {
		return args -> {
			if (adminRepository.count() == 0) {
				Admin admin = new Admin();
				admin.setUsername("admin");
				admin.setPassword("admin123");
				adminRepository.save(admin);
				System.out.println("Default admin user created: admin / admin123");
			}
		};
	}
}
