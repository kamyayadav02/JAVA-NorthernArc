package covariant;

public class Person {
    private String fname;
    private String lname;

    public Person(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }
    public void setFname(String fname) {
        this.fname=fname;
    }
    public void setLname(String lname) {
        this.lname=lname;
    }
    public Person getDemo(){
        return new Person("kamya","yadav");
    }
}
