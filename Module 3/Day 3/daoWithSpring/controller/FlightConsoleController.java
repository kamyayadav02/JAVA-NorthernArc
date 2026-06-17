package consoleController;

import dao.FlightDao;
import entity.Flight;

import java.sql.Date;
import java.sql.Time;
import java.util.Scanner;

public class FlightConsoleController {
    private Scanner scanner;
    private FlightDao flightDao;

    public FlightConsoleController(Scanner scanner, FlightDao flightDao) {
        this.scanner = scanner;
        this.flightDao = flightDao;
    }
    public void printWelcomeMessage() {
        System.out.println("Welcome to Flight services..");
    }

    public void showMenu(){
        while(true){
            System.out.println("1: Add");
            System.out.println("2: Find By Flight Number: ");
            System.out.println("3: Delete By Flight Number");
            System.out.println("4: Update");
            System.out.println("5: Delete all");
            System.out.println("6: List all");
            System.out.println("7: Find by Source, Destination and Departure date ");

            int choice = scanner.nextInt();
            redirectChoice(choice);
        }
    }
    private void redirectChoice(int choice){
        switch (choice){
            case 1:
                add();
                break;
            case 2:
                findByFlightNum();
                break;
            case 3:
                deleteByFlightNum();
                break;
            case 4:
                update();
                break;
            case 5:
                deleteAll();
                break;
            case 6:
                listAll();
                break;
            case 7:
                findBySourceAndDestinationAndDepartureDate();
                break;
            default:
                System.out.println("Invalid Choice.");
        }
    }

    private void listAll(){
        System.out.println(flightDao.findAll());
    }

    private void deleteByFlightNum(){
        System.out.println("Enter flight number: ");
        String num=scanner.next();
        flightDao.deleteByFlightNum(num);
    }

    private void findByFlightNum(){
        System.out.println("Enter flight number: ");
        String num=scanner.next();
        Flight flight=flightDao.findByFlightNum(num);
        if (flight != null) {
            System.out.println(flight);
        } else {
            System.out.println("Flight not found");
        }
    }

    private void update(){
        System.out.println("Enter flight number to update details: ");
        String num=scanner.next();
        scanner.nextLine();
        System.out.println("Enter new source: ");
        String source = scanner.nextLine();
        System.out.println("Enter new destination: ");
        String destination = scanner.nextLine();
        System.out.println("Enter new date of departure: ");
        Date dod= Date.valueOf(scanner.next());
        System.out.println("Enter new date of arrival");
        Date doa= Date.valueOf(scanner.next());
        System.out.println("Enter new time of departure: ");
        Time tod= Time.valueOf(scanner.next());
        System.out.println("Enter new time of arrival");
        Time toa= Time.valueOf(scanner.next());
        System.out.println("Enter cost per seat: ");
        int cost=scanner.nextInt();
        System.out.println("Enter number of seats: ");
        int seat= scanner.nextInt();
    }
    public void add(){
        System.out.println("Enter flight number:");
        String flightNum = scanner.next();
        scanner.nextLine();
        System.out.println("Enter new source: ");
        String source = scanner.nextLine();
        System.out.println("Enter new destination: ");
        String destination = scanner.nextLine();
        System.out.println("Enter new date of departure: ");
        Date dod= Date.valueOf(scanner.next());
        System.out.println("Enter new date of arrival");
        Date doa= Date.valueOf(scanner.next());
        System.out.println("Enter new time of departure: ");
        Time tod= Time.valueOf(scanner.next());
        System.out.println("Enter new time of arrival");
        Time toa= Time.valueOf(scanner.next());
        System.out.println("Enter cost per seat: ");
        int cost=scanner.nextInt();
        System.out.println("Enter number of seats: ");
        int seat= scanner.nextInt();
        flightDao.save(new Flight(flightNum,source,destination,dod,doa,tod,toa,cost,seat));


    }
    public void deleteAll() {
        System.out.println("Are you sure you want to delete all flights? (yes/no)");
        String confirm = scanner.next();

        if (confirm.equalsIgnoreCase("yes")) {
            flightDao.deleteAll();
            System.out.println("All flights deleted successfully.");
        } else {
            System.out.println("Operation cancelled.");
        }
    }

    private void findBySourceAndDestinationAndDepartureDate() {
        scanner.nextLine();  // clear buffer

        System.out.println("Enter source:");
        String source = scanner.nextLine();

        System.out.println("Enter destination:");
        String destination = scanner.nextLine();

        System.out.println("Enter departure date (yyyy-mm-dd):");
        Date dod = Date.valueOf(scanner.next());

        System.out.println(
                flightDao.findBySourceAndDestinationAndDepartureDate(source, destination, dod)
        );
    }

}
