package Aggregation;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private String hqLocation;
    private List<Employee> employees;

    public Department(String name, String hqLocation) {
        this.name = name;
        this.hqLocation = hqLocation;
        this.employees= new ArrayList<>();
    }
    public String toString() {
        return name + " " + hqLocation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHqLocation() {
        return hqLocation;
    }

    public void setHqLocation(String hqLocation) {
        this.hqLocation = hqLocation;
    }
    public void addEmployee(Employee employee){
        employees.add(employee);
    }
    public void removeEmployee(String employee){
        employees.remove(employee);
    }
    public List<Employee> getEmployees() {
        return employees;
    }

}
