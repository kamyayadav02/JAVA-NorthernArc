package Encapsulation;

public class Athlete {
    private String name;
    public String getName(){
        return name;
    }
    private String sport;
    public String getSport(){
        return sport;
    }
    private String team;
    public String getTeam(){
        return team;
    }
    public void setName(String n){
        this.name=n;
    }
    public void setSport(String s){
        this.sport=s;
    }
    public void setTeam(String t){
        this.team=t;
    }
    public void train(){
        System.out.println(this.name + "is training in" + this.sport);
    }
    public void compete(){
        System.out.println(this.name + "is competing in" + this.team);
    }
    public void getDetails(){
        System.out.println("name:" + this.name + "sport" + this.sport + "team" + this.team );
    }
}
