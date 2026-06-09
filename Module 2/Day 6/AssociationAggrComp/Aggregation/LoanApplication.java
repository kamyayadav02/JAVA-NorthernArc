package Aggregation;

public class LoanApplication {

    private String name;
    private int tenure;
    private double amount;
    private String fname;
    private String lname;

    public LoanApplication(String name, int tenure, double amount, String fname, String lname) {
        this.name = name;
        this.tenure = tenure;
        this.amount = amount;
        this.fname = fname;
        this.lname = lname;
    }

    public String getName() {
        return name;
    }

    public int getTenure() {
        return tenure;
    }

    public double getAmount() {
        return amount;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    @Override
    public String toString() {
        return "LoanApplication: " + name +
                ", Tenure: " + tenure +
                ", Amount: " + amount +
                ", Applicant: " + fname + " " + lname;
    }
}