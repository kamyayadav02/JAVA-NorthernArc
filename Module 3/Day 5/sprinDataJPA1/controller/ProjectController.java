package org.northernarc.springdatajpademo.controller;

import org.northernarc.springdatajpademo.model.Employee;
import org.northernarc.springdatajpademo.model.Project;
import org.northernarc.springdatajpademo.service.EmployeeService;
import org.northernarc.springdatajpademo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    @Autowired
    private EmployeeService employeeService;

     @GetMapping
     public List<Project> getAllProjects(){
         return projectService.getAllProjects();
     }

     @PostMapping("/add")
     public ResponseEntity<Project> addProject(@RequestBody Project project){
         return new ResponseEntity<>(projectService.addProject(project), HttpStatus.CREATED);
     }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        projectService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/assign/{pid}/{eid}")
    public ResponseEntity<Void> assignProjectToEmployee(@PathVariable Long pid, @PathVariable Long eid) {
        projectService.assignProject(pid, eid);
        return ResponseEntity.noContent().build();
    }
     @GetMapping("/employeesbyproject/{name}")
     public List<Employee> getEmployeesByProjectName(@PathVariable String name){
         return projectService.getEmployeesByProjectName(name);
     }
    @GetMapping("/projectsbyemployee/{name}")
    public List<Project> getProjectsByEmployeeName(@PathVariable String name){
        return projectService.getProjectsByEmployeeName(name);
    }

    @DeleteMapping("/unassign/{pid}/{eid}")
    public ResponseEntity<Void> unassignProjectFromEmployee(@PathVariable Long pid, @PathVariable Long eid) {
        projectService.unassignProject(pid, eid);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/projectbyemployee/{eid}")
    public List<Project> getProjectsByEmployeeId(@PathVariable Long eid) {
        return projectService.getProjectsByEmployeeId(eid);
    }

}


