package com.example.materia_seca;

import lombok.NonNull;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class MateriaSecaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MateriaSecaApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(@NonNull CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("http://localhost:4200") // Origen permitido (frontend Angular)
						.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos permitidos
						.allowedHeaders("*") // Permitir todos los encabezados
						.allowedHeaders("Authorization", "Content-Type")
						.allowCredentials(true);
			}
		};
	}

	//	For user other service
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
