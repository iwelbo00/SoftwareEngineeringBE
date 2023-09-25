package com.example.factory.SoftwareEngineering.services;
import com.example.factory.SoftwareEngineering.entity.userDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Service;
import com.example.factory.SoftwareEngineering.repository.userRepository;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.List;
import java.util.Optional;

@Service
public class userService {
    private final userRepository userRepository;


    @Autowired
    public userService(userRepository userRepository) {
        this.userRepository = userRepository;
    }

    public userDetails getUser(String username, String password){

        List<userDetails> temp = userRepository.findAll();
        for(userDetails iterator : temp){
            if(iterator.getUsername() == username
                    && iterator.getPasswordHash() == hashString(password)){
                return iterator;
            }
        }
        return null;
    }

    public userDetails createUser(String firstname, String lastname, String username, String plainPassword) {
        userDetails user = new userDetails();
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setUsername(username);

        // Hash the password
        String hashedPassword = hashString(plainPassword);
        user.setPasswordHash(hashedPassword);

        return userRepository.save(user);
    }

    public static String hashString(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(input.getBytes());

            Formatter formatter = new Formatter();
            for (byte b : hashBytes) {
                formatter.format("%02x", b);
            }
            return formatter.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
