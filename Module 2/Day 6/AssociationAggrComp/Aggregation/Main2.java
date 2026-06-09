package Aggregation;

public class Main2 {
    public static void main(String[] args) {
        Team northTeam= new Team("Team Slayers", "Delhi");
        Player player=new Player("Sachin");
        northTeam.addPlayer(player);
        northTeam.addPlayer(new Player("Sourav"));
        System.out.println("Players in North Team:");
        System.out.println(northTeam.getPlayers());
//        northTeam.removePlayer("Sachin");
//        System.out.println(northTeam.getPlayers());
        Team southTeam=new Team("Team Players","Bangalore");
        Player p=new Player("Raghav");
        southTeam.addPlayer(p);
        southTeam.addPlayer(new Player("Mahesh"));
        System.out.println("Players in South Team: ");
        System.out.println(southTeam.getPlayers());
    }
}
