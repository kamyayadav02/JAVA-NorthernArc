package Encapsulation;

public class Employee {
    private String name;
    private String position;
    private int salary;
    public String getName(){
        return name;
    }
    public void setName(String n){
        this.name=n;
    }
    public String getPosition(){
        return position;
    }
    public void setPosition(String p){
        this.position=p;
    }
    public int getSalary(){
        return salary;
    }
    public void setSalary(int s){
        this.salary=s;
    }
    public void work(){
        System.out.println(this.name + " is a " + this.position);
    }
    public void getDetails(){
        System.out.println("Name: " + this.name + "Position: " + this.position + " Salary: " + this.salary);
    }

}
