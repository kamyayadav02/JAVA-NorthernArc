package org.northernarc.jwtdemo.service;

import org.northernarc.jwtdemo.model.JPAUser;
import org.northernarc.jwtdemo.repo.JPARepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

@Service
public class JPAUserDetailService implements UserDetailsService {

    @Autowired
    private JPARepo jpaRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        JPAUser user = jpaRepo.findByUser(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return
                User.builder()
                        .username(user.getUser())
                .password(user.getPassword())
                .roles(user.getRole())
                .build();
    }
}
