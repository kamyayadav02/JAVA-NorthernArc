package Encapsulation;

public class Person {
    private String fname;
    private String lname;
    private int age;


    public Person(String fname, String lname, int age) {
        this.fname = fname;
        this.lname = lname;
        this.age = age;
    }


    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void eat(){
        System.out.println(this.fname + this.lname+ " is a vegetarian");
    }
    public void walk(){
        System.out.println(this.fname + " walks.");
    }
    public void talk(){
        System.out.println(this.fname + " talks in Hindi.");
    }
}
