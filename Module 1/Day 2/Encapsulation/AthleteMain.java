package Encapsulation;

public class AthleteMain {
    public static void main(String[] args) {
        Athlete a=new Athlete();
        a.setName("Diya");
        a.setTeam("CSK");
        a.setSport("Cricket");
        a.getDetails();
        a.compete();
    }
}
