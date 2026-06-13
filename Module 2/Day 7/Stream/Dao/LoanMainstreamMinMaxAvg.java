package LoanDao;

import entity.Loan;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LoanMainstreamMinMaxAvg {
    public static void main(String[] args) {


        LoanDao dao = new LoanDaoImpl();
        dao.save(new Loan(1, 100000, 12, 10, "Approved", "Home loan"));
        dao.save(new Loan(2, 4000000, 12, 15, "Approved", "Vehicle loan"));
        dao.save(new Loan(3, 900000, 24, 20, "Pending", "Home loan"));
        dao.save(new Loan(4, 1000000, 12, 25, "Rejected", "Vehicle loan"));
        dao.save(new Loan(5, 2000000, 24, 10, "Rejected", "Home loan"));
        dao.save(new Loan(6, 1700000, 12, 15, "Approved", "Vehicle loan"));
        System.out.println(((List<Loan>) dao.findAll()).stream().max((Loan l1, Loan l2)->l1.getLoanAmount()-l2.getLoanAmount()));
        System.out.println(((List<Loan>) dao.findAll()).stream().min((Loan l1, Loan l2)->l1.getLoanAmount()-l2.getLoanAmount()));

        System.out.println(
                ((List<Loan>) dao.findAll())
                        .stream()
                        .mapToDouble(Loan::getLoanAmount)
                        .average()
        );


        //we can find sum direct by using sum() also instead of using reduce
        System.out.println(
                ((List<Loan>) dao.findAll())
                        .stream()
                        .mapToInt(Loan::getLoanAmount)
                        .sum()
        );


        //here we are finding the sum using reduce
        int total=((List<Loan>) dao.findAll()).stream().mapToInt(Loan::getLoanAmount).reduce(0,(a,current)->a+current);
        System.out.println("Total loan amount: " +total);

        //((List<Loan>) dao.findAll()).stream().forEach((Loan loan)-> System.out.println(loan));
        ((List<Loan>) dao.findAll()).stream().forEach(System.out::println);  //using functional reference




    }

}
