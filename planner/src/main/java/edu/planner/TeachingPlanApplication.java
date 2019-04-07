package edu.planner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class TeachingPlanApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeachingPlanApplication.class, args);
	}
}