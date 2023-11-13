package com.senescyt.app;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.TimeZone;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "INTERFAZ SWAGGER PARA LA RESERVA DE SALONES DE EVENTOS",
				version = "1.0.0",
				description = "PROYECTO REALIZADO POR EL M5A",
				termsOfService = "M5A",
				contact = @Contact(
						name = "Instituto Superior Tecnologico Del Azuay",
						email = "info@tecazuay.edu.ec"
				)
		)
)
public class SenescytApplication {

	public static void main(String[] args) {
		TimeZone defaultTimeZone = TimeZone.getDefault();
		System.out.println("Zona horaria predeterminada: " + defaultTimeZone.getID());
		SpringApplication.run(SenescytApplication.class, args);

	}



	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST","PUT", "DELETE");
			}
		};
	}
}
