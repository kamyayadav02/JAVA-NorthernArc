package entity;

public class Loan {
    private int loanId;
    private int loanAmount;
    private int loanTenure;
    private int loanInterest;
    private String loanStatus;
    private String loanType;

    public Loan(int loanId, int loanAmount, int loanTenure, int loanInterest, String loanStatus, String loanType) {
        this.loanId = loanId;
        this.loanAmount = loanAmount;
        this.loanTenure = loanTenure;
        this.loanInterest = loanInterest;
        this.loanStatus = loanStatus;
        this.loanType = loanType;
    }
    public String toString(){
        return loanId+" "+ loanAmount+ " " + loanTenure+ " " + loanInterest+ " "+ loanStatus + " "+ loanType;
    }

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public int getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(int loanAmount) {
        this.loanAmount = loanAmount;
    }

    public int getLoanTenure() {
        return loanTenure;
    }

    public void setLoanTenure(int loanTenure) {
        this.loanTenure = loanTenure;
    }

    public int getLoanInterest() {
        return loanInterest;
    }

    public void setLoanInterest(int loanInterest) {
        this.loanInterest = loanInterest;
    }

    public String getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(String loanStatus) {
        this.loanStatus = loanStatus;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }
}
