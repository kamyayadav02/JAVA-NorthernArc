package config;

import config.dbManager;
import controller.LeaseConsoleController;
import controller.ProductConsoleController;
import controller.TodoConsoleController;
import dao.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
public class SpringConfiguration {

    @Bean("todoColl")
    public ToDoDao todoDao() {
        return new ToDoDaoImplCollections();
    }

    @Bean("todoJDBC")
    public ToDoDao toDoDao(dbManager db) {
        return new ToDoDaoImplJDBC(db);
    }

    @Bean("productJDBC")
    public ProductDao product(dbManager db){
        return new ProductDaoImplJDBC(db);
    }

    @Bean("productColl")
    public ProductDao productDao() {
        return new ProductDaoImplCollections();
    }

    @Bean("leaseJDBC")
    public LeaseDao leaseDao(dbManager db) {
        return new LeaseDaoImplJDBC(db);
    }

    @Bean("leaseColl")
    public LeaseDao leaseDaoColl() {
        return new LeaseDaoImplCollections();
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
    public TodoConsoleController consoleController(
            Scanner scanner,
            @Qualifier("todoJDBC") ToDoDao todoDao) {

        return new TodoConsoleController(scanner, todoDao);
    }

    @Bean
    public ProductConsoleController productConsoleController(
            Scanner scanner,
            @Qualifier("productColl") ProductDao productDao) {

        return new ProductConsoleController(scanner, productDao);
    }

    @Bean
    public LeaseConsoleController leaseConsoleController(
            Scanner scanner,
            @Qualifier("leaseColl") LeaseDao leaseDao) {

        return new LeaseConsoleController(scanner, leaseDao);
    }
}

