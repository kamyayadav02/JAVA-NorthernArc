package Encapsulation;

public class Chair {
    private String material;
    private String color;
    private int weight;
    public String getmaterial(){
        return material;
    }
    public String getcolor(){
        return color;
    }
    public int getweight(){
        return weight;
    }
    public void setMaterial(String m){
        this.material=m;
    }
    public void setColor(String c){
        this.color=c;
    }
    public void setWeight( int w){
        this.weight=w;
    }
    public Chair ( String material, String color, int weight){
        this.material=material;
        this.color=color;
        this.weight=weight;
    }
    public void adjustHeight(){
        System.out.println("The height of chair is: "  );
    }
    public void getDetails(){
        System.out.println("The chair is made of" + this.material + " and color is " + this.color + " and weight is" + this.weight );
    }
}
