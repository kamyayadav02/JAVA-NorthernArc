package Aggregation;
import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private String origin;
    private List<Player> players;

    public Team(String name, String origin) {
        this.name = name;
        this.origin = origin;
        this.players= new ArrayList<>();
    }
    public String toString() {
        return name + " " + origin;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getOrigin() {

        return origin;
    }

    public void setOrigin(String origin) {

        this.origin = origin;
    }
    public void addPlayer(Player player){
        players.add(player);
    }
    public void removePlayer(String player){

        players.remove(player);
    }
    public List<Player> getPlayers() {
        return players;
    }

}
