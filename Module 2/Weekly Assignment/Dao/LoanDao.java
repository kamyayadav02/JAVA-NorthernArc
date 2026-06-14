package dao;

import entity.Loan;
import java.util.Collection;

public interface LoanDao {

    int save(Loan loan);

    Loan findById(int loanid);

    Collection<Loan> findAll();

    void deleteById(int loanid);

    void updateById(int loanid, Loan loan);

    Collection<Loan> findByStatus(String status);

    Collection<Loan> findByType(String loanType);
}
