package main;

import config.SpringConfiguration;
import controller.LeaseConsoleController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LeaseMainConsoleController {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfiguration.class);

        LeaseConsoleController controller =
                context.getBean(LeaseConsoleController.class);

        System.out.println("Welcome to Lease System..");
        controller.showMenu();
    }
}