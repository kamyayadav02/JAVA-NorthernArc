package com.northernArc.firstbootapp;

import com.northernArc.firstbootapp.controller.ToDoConsoleController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstbootappApplication implements CommandLineRunner {
	@Autowired
	ToDoConsoleController toDoConsoleController;

	public static void main(String[] args) {
		SpringApplication.run(FirstbootappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		toDoConsoleController.showMenu();

	}
}
