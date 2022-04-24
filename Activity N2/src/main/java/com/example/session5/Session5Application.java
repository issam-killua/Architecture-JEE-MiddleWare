package com.example.session5;

import com.example.session5.entities.Role;
import com.example.session5.entities.User;
import com.example.session5.service.UserService;
import com.example.session5.service.UserServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class Session5Application {

    public static void main(String[] args) {
        SpringApplication.run(Session5Application.class, args);

    }
    @Bean
    CommandLineRunner start(UserService userService){
        return args -> {
            User u =new User();
            u.setUsername("user1");
            u.setPassword("123456789");
            userService.addNewUser(u);

            User u2 =new User();
            u2.setUsername("admin");
            u2.setPassword("987654321");
            userService.addNewUser(u2);


            Stream.of("STUDENT","USER","ADMIN").forEach(r->{
                Role role1 = new Role();
                role1.setRoleNom(r);
                //role1.setDesc();
                userService.addNewRole(role1);
            });

            userService.addRoleToUser("user1","STUDENT");
            userService.addRoleToUser("user1","USER");
            userService.addRoleToUser("admin","USER");
            userService.addRoleToUser("admin","ADMIN");

            try{
                User user = userService.authenticate("user1","123456789");
                System.out.println(user.getUserId());
                System.out.println(user.getUsername());
                System.out.println("Roles=>");
                user.getRoles().forEach(r->{
                    System.out.println("Roles=>"+r.toString());
                });
            }catch (Exception e){
                e.printStackTrace();
            }

        };
    }

}
