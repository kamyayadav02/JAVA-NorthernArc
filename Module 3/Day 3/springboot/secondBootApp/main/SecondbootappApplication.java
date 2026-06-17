package com.northernArc.secondbootapp;

import com.northernArc.secondbootapp.consoleController.BookConsoleController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecondbootappApplication implements CommandLineRunner {
@Autowired
	BookConsoleController bookConsoleController;

	public static void main(String[] args) {
		SpringApplication.run(SecondbootappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		bookConsoleController.showMenu();

	}
}
