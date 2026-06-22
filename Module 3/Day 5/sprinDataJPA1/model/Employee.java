package org.northernarc.springdatajpademo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Entity
@Data
public class Employee {
                    @Id
                    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String dept;
    @ManyToMany(mappedBy = "employees")
    @JsonIgnore
    private List<Project> projects;


}
