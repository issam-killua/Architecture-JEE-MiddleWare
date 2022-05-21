package com.example.etudiantmvc;

import com.example.etudiantmvc.entities.Etudiant;
import com.example.etudiantmvc.repositories.EtudiantRepository;
import com.example.etudiantmvc.security.services.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class EtudiantmvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(EtudiantmvcApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(EtudiantRepository etudiantRepo) {
        return args -> {
            etudiantRepo.save(new Etudiant(null, "Bouizou", "Issam", "issam@gmail.com", new Date(), "MASCULIN", true));
            etudiantRepo.save(new Etudiant(null, "Ouaziz", "Soufiane", "soufiane@enset.ma", new Date(), "MASCULIN", true));
            etudiantRepo.save(new Etudiant(null, "Oumakhou", "Younes", "younes@enset.ma", new Date(), "MASCULIN", true));
            etudiantRepo.save(new Etudiant(null, "Zalhat", "Mehdi", "mehdi@enset.ma", new Date(), "MASCULIN", true));
            etudiantRepo.save(new Etudiant(null, "Ghiati", "Hassan", "hassan@enset.ma", new Date(), "MASCULIN", true));
            etudiantRepo.save(new Etudiant(null, "El kamouni", "Soukaina", "soukaina@enset.ma", new Date(), "FEMININ", false));
            etudiantRepo.save(new Etudiant(null, "Bouhali", "Imad", "imad@enset.ma", new Date(), "MASCULIN", false));
            etudiantRepo.save(new Etudiant(null, "Benaaki", "Brahim", "brahim@enset.ma", new Date(), "MASCULIN", false));
            etudiantRepo.save(new Etudiant(null, "Essadiki", "Manal", "manal@enset.ma", new Date(), "FEMININ", false));
            etudiantRepo.save(new Etudiant(null, "Aghrai", "Oumaima", "oumaima@enset.ma", new Date(), "FEMININ", true));

            etudiantRepo.findAll().forEach( p -> {
                System.out.println(p.getNom());
            });
        };
    }


    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //@Bean
    CommandLineRunner saveUsers(SecurityService securityService) {
        return args -> {
            securityService.saveNewUser("amine", "test", "test");
            securityService.saveNewUser("mod", "test", "test");

            securityService.saveNewRole("USER", "");
            securityService.saveNewRole("ADMIN", "");

            securityService.addRoleToUser("amine", "USER");
            securityService.addRoleToUser("mod", "USER");
            securityService.addRoleToUser("mod", "ADMIN");
        };
    }

}
