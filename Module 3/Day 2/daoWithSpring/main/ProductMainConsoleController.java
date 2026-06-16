package main;

import config.SpringConfiguration;
import controller.ProductConsoleController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class ProductMainConsoleController {
    public static void main(String[] args) throws SQLException {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        ProductConsoleController productConsoleController = context.getBean(ProductConsoleController.class);
        productConsoleController.printWelcomeMessage();
        productConsoleController.showMenu();
    }
}
