package com.northernArc.thirdbootapp.consoleController;

import com.northernArc.thirdbootapp.dao.FlightDao;
import com.northernArc.thirdbootapp.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Scanner;

@Component
public class FlightConsoleController {
    @Autowired
    private Scanner scanner;
    
    @Autowired
    private FlightDao flightDao;

    public void printWelcomeMessage(){
        System.out.println("Welcome to Todo Dao service..");
    }
    public void showMenu() throws SQLException {
        while (true) {
            System.out.println("1. Add");
            System.out.println("2. Update");
            System.out.println("3. Delete");
            System.out.println("4. List All");
            System.out.println("5. Find By flight number");
            int choice = scanner.nextInt();
            redirectChoice(choice);
        }
    }
    private void redirectChoice(int choice) throws SQLException{
        switch (choice){
            case 1:
                add();
                break;
            case 2:
                update();
                break;
            case 3:
                delete();
                break;
            case 4:
                listAll();
                break;
            case 5:
                findByFlightNum();
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    private void update() {

        System.out.println("Enter id of flight to be updated:");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter flight number:");
        String flightNum = scanner.nextLine();

        System.out.println("Enter source:");
        String source = scanner.nextLine();

        System.out.println("Enter destination:");
        String destination = scanner.nextLine();

        System.out.println("Enter date of departure (yyyy-mm-dd):");
        Date dod = Date.valueOf(scanner.nextLine());

        System.out.println("Enter date of arrival (yyyy-mm-dd):");
        Date doa = Date.valueOf(scanner.nextLine());

        System.out.println("Enter time of departure (hh:mm:ss):");
        Time tod = Time.valueOf(scanner.nextLine());

        System.out.println("Enter time of arrival (hh:mm:ss):");
        Time toa = Time.valueOf(scanner.nextLine());

        System.out.println("Enter cost per seat:");
        int costPerSeat = scanner.nextInt();

        System.out.println("Enter number of seats:");
        int numOfSeat = scanner.nextInt();

        flightDao.updateByFlightNum(flightNum, new Flight(
                flightNum, source, destination,
                dod, doa, tod, toa,
                costPerSeat, numOfSeat
        ));

    }

    private void findByFlightNum() {
        System.out.println("Enter flight number to find:");
        String flightNum = scanner.nextLine();
        scanner.nextLine();
        System.out.println(flightDao.findByFlightNum(flightNum));
        
    }

    private void delete() {
        System.out.println("Enter flight number to be deleted:");
        String flightNum=scanner.nextLine();
        flightDao.deleteByFlightNum(flightNum);
        
    }

    private void add() {
        System.out.println("Enter id of flight to be updated:");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter flight number:");
        String flightNum = scanner.nextLine();

        System.out.println("Enter source:");
        String source = scanner.nextLine();

        System.out.println("Enter destination:");
        String destination = scanner.nextLine();

        System.out.println("Enter date of departure (yyyy-mm-dd):");
        Date dod = Date.valueOf(scanner.nextLine());

        System.out.println("Enter date of arrival (yyyy-mm-dd):");
        Date doa = Date.valueOf(scanner.nextLine());

        System.out.println("Enter time of departure (hh:mm:ss):");
        Time tod = Time.valueOf(scanner.nextLine());

        System.out.println("Enter time of arrival (hh:mm:ss):");
        Time toa = Time.valueOf(scanner.nextLine());

        System.out.println("Enter cost per seat:");
        int costPerSeat = scanner.nextInt();

        System.out.println("Enter number of seats:");
        int numOfSeat = scanner.nextInt();
        flightDao.save(new Flight(flightNum, source, destination,
                dod, doa, tod, toa, costPerSeat, numOfSeat));

        
    }

    private void listAll(){
        System.out.println(flightDao.findAll());
    }
    
}
