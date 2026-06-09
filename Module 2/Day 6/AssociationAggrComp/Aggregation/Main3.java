package Aggregation;

public class Main3 {

    public static void main(String[] args) {


        Underwriter uw1 = new Underwriter("Underwriter A");

        LoanApplication l1 = new LoanApplication("HomeLoan", 10, 500000, "Raj", "Sharma");
        uw1.addApplication(l1);
        uw1.addApplication(new LoanApplication("CarLoan", 5, 200000, "Amit", "Verma"));

        System.out.println("Applications under Underwriter A:");
        System.out.println(uw1.getApplications());

        Underwriter uw2 = new Underwriter("Underwriter B");

        LoanApplication l2 = new LoanApplication("PersonalLoan", 3, 100000, "Neha", "Singh");
        uw2.addApplication(l2);
        uw2.addApplication(new LoanApplication("EducationLoan", 7, 300000, "Priya", "Kapoor"));

        System.out.println("Applications under Underwriter B:");
        System.out.println(uw2.getApplications());
    }
}
