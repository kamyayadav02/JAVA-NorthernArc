package LoanDao;

import entity.Loan;

public interface LoanDao  {
    public void save(Loan loan);
    public Loan findByLoanId(int loanId);
    public void deleteById(int LoanId);
    public void update(Loan loan);
    public void deleteAll();
    public Iterable<Loan> findAll();
    public Iterable<Loan> findByStatus( String loanStatus);
    public Iterable<Loan> findByType(String loanType );


}
