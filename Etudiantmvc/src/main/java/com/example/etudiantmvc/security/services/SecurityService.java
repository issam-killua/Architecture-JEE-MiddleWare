package com.example.etudiantmvc.security.services;


import com.example.etudiantmvc.security.entities.AppRole;
import com.example.etudiantmvc.security.entities.AppUser;

public interface SecurityService {
    AppUser saveNewUser(String username, String password, String confirmPassword);
    AppRole saveNewRole(String roleName, String roleDescription);
    void addRoleToUser(String username, String roleName);
    void removeRoleFromUser(String username, String roleName);
    AppUser loadUserByUserName(String username);
}
