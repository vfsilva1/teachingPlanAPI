package edu.planner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import edu.planner.service.DBService;

@SpringBootApplication
@ComponentScan
public class TeachingPlanApplication implements CommandLineRunner {

	@Autowired
	private DBService dbService;

	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;

	public static void main(String[] args) {
		SpringApplication.run(TeachingPlanApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		if ("create".equals(strategy)) {
			dbService.instantiateTestDatabase();
		}
	}
}