package encapsulation;

public class Main {
    public static void main(String[] args){
        Superhero hero=new Superhero();
        hero.name="Superman";
        hero.superpower= "flight";
        hero.useSuperPower();
        hero.saveTheWorld();

        Superhero hero2= new Superhero();
        hero2.name="Batman";
        hero2.superpower="intelligence";
        hero2.useSuperPower();
        hero2.saveTheWorld();
    }
    
}
