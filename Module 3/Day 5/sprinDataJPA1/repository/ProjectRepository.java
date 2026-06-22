package org.northernarc.springdatajpademo.repository;

import org.northernarc.springdatajpademo.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    Project findByName(String name);
}
