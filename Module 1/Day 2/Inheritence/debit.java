public class debit extends Payment {
    @Override
    public void makePayment(double amount){
        System.out.println("Making payment of " + amount + " rupees using debit card");
    }
    
}
