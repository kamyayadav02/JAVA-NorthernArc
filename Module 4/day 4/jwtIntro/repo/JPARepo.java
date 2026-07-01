package org.northernarc.jwtdemo.repo;

import org.apache.catalina.User;
import org.northernarc.jwtdemo.model.JPAUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JPARepo extends JpaRepository<JPAUser, Long> {
    public JPAUser findByUser(String user);

}
