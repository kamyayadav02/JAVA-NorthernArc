package Encapsulation;

public class EmployeeMain {
    public static void main(String[] args) {
        Employee e=new Employee();
        e.setName("Riya");
        e.setPosition("Vice President");
        e.setSalary(10000000);
        e.getDetails();
        e.work();
    }
}
