package upcast;

public class Employee extends Person{
    String dept;
    public Employee(String fname, String lname, String dept){
        super(fname, lname);
        this.dept=dept;
    }

    public String getDept() {
        return dept;
    }
    public String setDept(String dept){
        this.dept=dept;
        return dept;
    }
}
