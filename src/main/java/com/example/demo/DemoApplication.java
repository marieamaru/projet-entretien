package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.time.LocalDate;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	private TaskRepository taskRep;

	@Bean
	public CommandLineRunner commandLineRunner() {
		var task = new Task(1, "TaskOne", Type.PERSONAL, LocalDate.of(2022,8,25), true);
		taskRep.add(task);
		return null;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
