package com.example.patientsmvc;

import com.example.patientsmvc.entities.Patient;
import com.example.patientsmvc.repositories.PatientRepository;
import com.example.patientsmvc.sec.service.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class PatientsMvcApplication {

    public static void main(String[] args) {
        SpringApplication. run(PatientsMvcApplication.class, args);
    }

    //@Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository) {
        return args -> {
            patientRepository.save(new Patient(null,"hassan",new Date(),false,122));
            patientRepository.save(new Patient(null,"issam",new Date(),true,701));
            patientRepository.save(new Patient(null,"hanae",new Date(),true,170));
            patientRepository.save(new Patient(null,"ikram",new Date(),false,489));

            patientRepository.findAll().forEach(p->{
                System.out.println(p.getNom());
            });
        };
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

   //@Bean
    CommandLineRunner saveUsers(SecurityService securityService){
        return args ->{
            securityService.saveNewUser("soukaina","1234","1234");
            securityService.saveNewUser("rajae","1234","1234");
            securityService.saveNewUser("manal","1234","1234");

            securityService.saveNewRole("USER","");
            securityService.saveNewRole("ADMIN","");

            securityService.addRoleToUser("soukaina","USER");
            securityService.addRoleToUser("soukaina","ADMIN");
            securityService.addRoleToUser("rajae","USER");
            securityService.addRoleToUser("manal","USER");
        };
    }
}


