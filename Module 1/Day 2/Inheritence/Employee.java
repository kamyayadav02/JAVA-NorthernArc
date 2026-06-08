public class Employee extends Person {

    int empId;
    String department;
    double salary;

    public int getEmpId() {
        return empId;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
    

    public void setEmpId(int id) {
        this.empId = id;
    }

    public void setDepartment(String dept) {
        this.department = dept;
    }

    public void setSalary(double sal) {
        this.salary = sal;
    }

  
    public void work() {
        System.out.println(getFname() + " works in " + department + " department.");
    }

    public void getEmployeeDetails() {
        System.out.println(
            "fname: " + getFname() +
            " lname: " + getLname() +
            " age: " + getAge() +
            " empId: " + empId +
            " department: " + department +
            " salary: " + salary
        );
    }
}
