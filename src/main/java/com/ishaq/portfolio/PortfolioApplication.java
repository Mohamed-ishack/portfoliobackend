package com.ishaq.portfolio;

import com.ishaq.portfolio.Entity.Admin;
import com.ishaq.portfolio.Repository.AdminRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class PortfolioApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortfolioApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("http://localhost:5173", "http://localhost:5174", "https://portfoliobackend-1-xmt5.onrender.com")
						.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
						.allowedHeaders("*")
						.allowCredentials(true);
			}
		};
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
