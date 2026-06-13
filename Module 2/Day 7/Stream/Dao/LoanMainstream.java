package LoanDao;

import entity.Loan;
import java.util.*;
import java.util.List;

public class LoanMainstream {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LoanDao dao = new LoanDaoImpl();

        dao.save(new Loan(1,100000,12,10,"Approved","Home loan"));
        dao.save(new Loan(2,4000000,12,15,"Approved","Vehicle loan"));
        dao.save(new Loan(3,900000,24,20,"Pending","Home loan"));
        dao.save(new Loan(4,1000000,12,25,"Rejected","Vehicle loan"));
        dao.save(new Loan(5,2000000,24,10,"Rejected","Home loan"));
        dao.save(new Loan(6,1700000,12,15,"Approved","Vehicle loan"));

        System.out.println("Filter by:");
        System.out.println("1. Status");
        System.out.println("2. Type");
        int choice = sc.nextInt();
        sc.nextLine();

        List<Loan> result = new ArrayList<>();

        switch (choice) {

            case 1:
                System.out.print("Enter Status: ");
                String status = sc.nextLine();

                result = ((List<Loan>) dao.findAll()).stream()
                        .filter(loan -> loan.getLoanStatus().equalsIgnoreCase(status))
                        .toList();
                break;

            case 2:
                System.out.print("Enter Type: ");
                String type = sc.nextLine();

                result = ((List<Loan>) dao.findAll()).stream()
                        .filter(loan -> loan.getLoanType().equalsIgnoreCase(type))
                        .toList();
                break;

            default:
                System.out.println("Invalid choice");
        }

        System.out.println("Filtered Loans:");
        System.out.println(result);
    }
}
