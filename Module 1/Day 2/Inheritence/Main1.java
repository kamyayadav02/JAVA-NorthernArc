public class Main1 {
    public static void main(String[] args) {

        
        Person emp = new Employee();

        emp.setFname("Riya");
        emp.setLname("Singh");
        emp.setAge(26);

        Employee downCastedEmp = (Employee) emp;

        downCastedEmp.setEmpId(123); 
        downCastedEmp.setDepartment("IT");
        emp.showDetails();
        emp.eat();
        emp.walk();
        emp.talk();

        downCastedEmp.work();
    }
}