package com.example.session5.service;

import com.example.session5.entities.Role;
import com.example.session5.entities.User;

public interface UserService {
    User addNewUser(User user);
    Role addNewRole (Role role);
    User findUserByUserName(String userName);
    Role findRoleByRoleName(String RoleName);
    void addRoleToUser(String userName,String RoleName);
    User authenticate(String userName, String password);

}
