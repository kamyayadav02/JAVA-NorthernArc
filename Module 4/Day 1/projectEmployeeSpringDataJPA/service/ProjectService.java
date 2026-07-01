package org.northernarc.springdatajpademo.service;

import org.northernarc.springdatajpademo.exceptions.EmployeeNotFound;
import org.northernarc.springdatajpademo.exceptions.ProjectNotFound;
import org.northernarc.springdatajpademo.model.Employee;
import org.northernarc.springdatajpademo.model.Project;
import org.northernarc.springdatajpademo.repository.EmployeeRepository;
import org.northernarc.springdatajpademo.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public Project addProject(Project project) {
        return projectRepository.save(project);
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public void deleteById(Long id) {
        projectRepository.deleteById(id);
    }

    public void assignProject(Long pid, Long eid) {

        Project project = projectRepository.findById(pid).orElseThrow(() -> new ProjectNotFound("Project not found with id : " + pid));

        Employee employee = employeeRepository.findById(eid).orElseThrow(() -> new EmployeeNotFound("Employee not found with id : " + eid));

        project.getEmployees().add(employee);

        projectRepository.save(project);
    }

    public void unassignProject(Long pid, Long eid) {

        Project project = projectRepository.findById(pid)
                .orElseThrow(() -> new ProjectNotFound("Project not found with id: " + pid));

        project.getEmployees().removeIf(employee -> employee.getId().equals(eid));

        projectRepository.save(project);
    }

    public List<Employee> getEmployeesByProjectName(String name) {

        Project project = projectRepository.findByName(name);

        if (project == null) {
            throw new ProjectNotFound("Project not found with name : " + name);
        }
        return project.getEmployees();
    }

    public List<Project> getProjectsByEmployeeName(String name) {
        Employee employee = employeeRepository.findByName(name);

        if (employee == null) {
            throw new EmployeeNotFound("Employee not found with name : " + name);
        }
        return employee.getProjects();
    }

    public List<Project> getProjectsByEmployeeId(Long eid) {

        Employee employee = employeeRepository.findById(eid)
                .orElseThrow(() -> new EmployeeNotFound("Employee not found with id: " + eid));

        return employee.getProjects();
    }
}