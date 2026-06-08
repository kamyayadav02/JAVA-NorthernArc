public class credit extends Payment {
    @Override
    public void makePayment(double amount){
        System.out.println("Making payment of " + amount + " rupees using credit card");
    }

    
}
