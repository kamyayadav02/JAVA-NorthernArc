package com.northernArc.thirdbootapp;

import com.northernArc.thirdbootapp.consoleController.FlightConsoleController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThirdbootappApplication implements CommandLineRunner {
	@Autowired
	FlightConsoleController flightConsoleController;

	public static void main(String[] args) {
		SpringApplication.run(ThirdbootappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		flightConsoleController.showMenu();
	}
}
