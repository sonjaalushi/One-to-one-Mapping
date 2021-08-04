package com.example.onetoone;

import com.example.onetoone.entity.Gender;
import com.example.onetoone.entity.User;
import com.example.onetoone.entity.UserProfile;
import com.example.onetoone.repository.UserProfileRepository;
import com.example.onetoone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;

import java.time.LocalDate;

@SpringBootApplication
public class OneToOneApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(OneToOneApplication.class, args);
    }

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserProfileRepository userProfileRepository;

    @Override
    public void run(String... args) throws Exception {

        //user object
        User user = new User();
        user.setName("Sonja");
        user.setEmail("sonjaalushi5@gmail.com");

        UserProfile userProfile = new UserProfile();
        userProfile.setAddress("Tirane");
        userProfile.setBirthOfDate(LocalDate.of(2001, 5, 11));
        userProfile.setGender(Gender.FEMALE);
        userProfile.setPhoneNumber("123456789");

        user.setUserProfile(userProfile);
        userProfile.setUser(user);

        userRepository.save(user);
        userRepository.delete(user);

    }
}
