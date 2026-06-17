package main;

import config.SpringConfiguration;
import consoleController.FlightConsoleController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        FlightConsoleController flightConsoleController = context.getBean(FlightConsoleController.class);
        flightConsoleController.printWelcomeMessage();
        flightConsoleController.showMenu();

    }
}
