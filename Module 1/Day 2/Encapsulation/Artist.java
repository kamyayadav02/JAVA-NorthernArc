package Encapsulation;

public class Artist {

    private String name;
    public String getName(){
        return name;
    }
    private String artStyle;
    public String getArtStyle(){
        return artStyle;
    }
    private String medium;
    public String getMedium(){
        return medium;
    }
    public void setName(String n){
        this.name =n;
    }
    public void setArtStyle(String as){
        this.artStyle=as;
    }
    public void setMedium(String m){
        this.medium=m;
    }
    public void create(){
        System.out.println(this.name + "is a creator.");
    }
    public void getDetails(){
        System.out.println("name: " + this.name + " Art style: " + this.artStyle + " medium: " + this.medium);
    }}
