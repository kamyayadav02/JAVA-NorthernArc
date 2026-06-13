package LoanDao;

import entity.Loan;

import java.util.Comparator;
import java.util.List;
import java.util.function.UnaryOperator;


public class LoanMainstreamUnary {
    public static void main(String[] args) {


        LoanDao dao = new LoanDaoImpl();
        dao.save(new Loan(1, 100000, 12, 10, "Approved", "Home loan"));
        dao.save(new Loan(2, 4000000, 12, 15, "Approved", "Vehicle loan"));
        dao.save(new Loan(3, 900000, 24, 20, "Pending", "Home loan"));
        dao.save(new Loan(4, 1000000, 12, 25, "Rejected", "Vehicle loan"));
        dao.save(new Loan(5, 2000000, 24, 10, "Rejected", "Home loan"));
        dao.save(new Loan(6, 1700000, 12, 15, "Approved", "Vehicle loan"));
//        class myOperator implements UnaryOperator<Loan> {
//            @Override
//            public Loan apply(Loan loan) {
//                loan.setLoanInterest(loan.getLoanInterest() + 2); //increasing every interest by 2
//                return loan;
//            }
//
//            UnaryOperator op1 = new myOperator();
//            List<Loan> newLoans = loans.stream.map(op1).toList();
//
//            public void setOp1(UnaryOperator op1) {
//                System.out.println(newLoans);
//            }
//        }
//    }
        List<Loan> newLoans=((List<Loan>) dao.findAll()).stream()
                .filter(loan -> loan.getLoanType().equals("Vehicle loan"))
                .map((Loan loan)->{
            loan.setLoanInterest(loan.getLoanInterest()+2);
            return loan;
        }).sorted(Comparator.comparing(Loan::getLoanAmount).reversed())
                .toList();
        System.out.println(newLoans);
    }
}