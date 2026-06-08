package association;

public class PassMain {
    public static void main(String[] args){

        Person p = new Person("John", "Doe");

        Passport passport = new Passport("P123456", "USA", "01-01-2020", "01-01-2030");

        passport.setPerson(p);


        System.out.println("Passport Number: " + passport.getPassportNo() + "Country: "  + passport.getCountry() + "Issue Date: " + passport.getIssueDate() + "Expiry Date: " + passport.getExpiryDate());

        System.out.println("Holder Name: " + passport.getPerson());
        System.out.println(passport);




    }

}
