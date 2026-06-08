package Assignment;

public class BankAccount {
    private String AccountOwner;
    private double Balance;


    public String getAccountOwner() {
        return AccountOwner;
    }

    public double getBalance() {
        return Balance;
    }


    public void setAccountOwner(String ao) {
        this.AccountOwner = ao;
    }

    public void setBalance(double b) {
        this.Balance = b;
    }


    public void deposit(double amount) {
        if (amount > 0) {
            this.Balance += amount;
            System.out.println("Amount deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    public void withdraw(double amount) {
        if (amount > Balance) {
            System.out.println("Insufficient balance");
        } else if (amount <= 0) {
            System.out.println("Invalid withdrawal amount");
        } else {
            this.Balance -= amount;
            System.out.println("Amount withdrawn: " + amount);
        }
    }

    public void checkBalance() {
        System.out.println("Current Balance: " + Balance);
    }
}