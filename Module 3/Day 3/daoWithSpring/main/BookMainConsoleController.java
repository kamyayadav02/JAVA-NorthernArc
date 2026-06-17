package main;

import config.SpringConfiguration;
import controller.BookConsoleController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class BookMainConsoleController {
    public static void main(String[] args) throws SQLException {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfiguration.class);
        BookConsoleController controller=context.getBean(BookConsoleController.class);
        System.out.println("Welcome to Book Library.");
        controller.showMenu();
    }
}
