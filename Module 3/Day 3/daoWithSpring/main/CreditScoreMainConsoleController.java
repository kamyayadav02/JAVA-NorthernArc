package main;

import config.SpringConfiguration;
import controller.BookConsoleController;
import controller.CreditScoreConsoleController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CreditScoreMainConsoleController {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfiguration.class);
        CreditScoreConsoleController controller=context.getBean(CreditScoreConsoleController.class);
        System.out.println("Welcome to Credit Library.");
        controller.showMenu();
    }
}
