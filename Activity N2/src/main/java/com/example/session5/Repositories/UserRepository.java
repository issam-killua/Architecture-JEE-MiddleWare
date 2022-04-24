package com.example.session5.Repositories;

import com.example.session5.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,String> {
    User findByUsername(String userName);
}
