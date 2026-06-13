package LoanDao;

import entity.Loan;

import java.util.ArrayList;
import java.util.List;

public class LoanDaoImpl implements LoanDao {
    private List<Loan> loans = new ArrayList<>();

    @Override
    public void save(Loan loan) {

        loans.add(loan);
    }

    @Override
    public Loan findByLoanId(int loanId) {
        for (Loan l : loans) {
            if (l.getLoanId() == loanId) {
                return l;
            }
        }
        return null;
    }

    @Override
    public void deleteById(int LoanId) {

    }

    @Override
    public void update(Loan loan) {
        for (Loan l : loans) {
            if (l.getLoanId() == loan.getLoanId()) {
                l.setLoanStatus(loan.getLoanStatus());
                l.setLoanType(loan.getLoanType());
                return;
            }
        }

    }

    @Override
    public void deleteAll() {
        loans.clear();

    }

    @Override
    public Iterable<Loan> findAll() {
        return loans;
    }


    @Override
    public Iterable<Loan> findByStatus(String loanStatus) {
        List<Loan> result = new ArrayList<>();
        for (Loan l : loans) {
            if (l.getLoanStatus().equalsIgnoreCase(loanStatus)) {
                result.add(l);
            }
        }
        return result;
    }

    @Override
    public Iterable<Loan> findByType(String loanType) {
        List<Loan> result = new ArrayList<>();
        for (Loan l : loans) {
            if (l.getLoanType().equalsIgnoreCase(loanType)) {
                result.add(l);
            }
        }
        return result;
    }




}
