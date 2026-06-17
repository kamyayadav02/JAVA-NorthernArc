package config;

import consoleController.FlightConsoleController;
import dao.FlightDao;
import dao.FlightDaoImpl;
import dbManager.dbManager;
import entity.Flight;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
public class SpringConfiguration {

    @Bean("flightJDBC")
    public FlightDao flightDao(dbManager db) {
        return new FlightDaoImpl(db);
    }

    @Bean
    public dbManager dbManager() {
        return new dbManager(
                "jdbc:postgresql://localhost:5432/northernarc",
                "postgres",
                "12345");
    }

    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }

    @Bean
    public FlightConsoleController flightConsoleController(Scanner scanner, FlightDao flightDao) {
        return new FlightConsoleController(scanner, flightDao);
    }

}
