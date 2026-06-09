package Aggregation;

public class Main1 {
    public static void main(String[] args) {
        Department itDept= new Department("it", "Bangalore");
        Employee employee=new Employee("Sachin");
        itDept.addEmployee(employee);
        itDept.addEmployee(new Employee("Sourav"));
        System.out.println("Employees in IT:");
        System.out.println(itDept.getEmployees());
//        itDept.removeEmployee("Sachin");
//        System.out.println(itDept.getEmployees());
        Department hrDept=new Department("hr","Bangalore");
        Employee e=new Employee("Riya");
        hrDept.addEmployee(e);
        hrDept.addEmployee(new Employee("Siya"));
        System.out.println("Employees in Hr: ");
        System.out.println(hrDept.getEmployees());
    }
}
