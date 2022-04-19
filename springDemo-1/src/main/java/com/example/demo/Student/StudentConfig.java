package com.example.demo.Student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;


@Configuration
@Order(1)
public class StudentConfig {
	
	@Bean
	CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
		return args -> {
			Student berk = new Student(
					
					"berk",
					"berk@gmail.com",
					LocalDate.of(2000, 1 ,1)
			);
			Student dilara = new Student(
					
					"dilara",
					"dilara@gmail.com",
					LocalDate.of(2000, 7, 1)
			);
			studentRepository.saveAll(List.of(berk,dilara));
		};
	}
}
