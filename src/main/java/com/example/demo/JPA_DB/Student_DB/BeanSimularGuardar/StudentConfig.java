package com.example.demo.JPA_DB.Student_DB.BeanSimularGuardar;
 
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.JPA_DB.Student_DB.StudentDB;
import com.example.demo.JPA_DB.Student_DB.StudentRepositoryNormal;
 
@Configuration
public class StudentConfig {

	@Bean
	CommandLineRunner commandLineRunner(
			StudentRepositoryNormal studentRepository) {
		return args -> {
			StudentDB estudiante1 = new StudentDB(
			            "Nombre1",
			            "Apellido1",
			            "email",
			            21
						);
			
			StudentDB estudiante2 = new StudentDB(
		            "Nombre2",
		            "Apellido2",
		            "email",
		            21
					);
			
			studentRepository.saveAll(
							List.of(estudiante1, estudiante2)
						);
		};
	}
}
