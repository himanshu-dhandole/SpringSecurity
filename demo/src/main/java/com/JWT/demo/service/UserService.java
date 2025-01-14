package com.JWT.demo.service;

import com.JWT.demo.model.Users;
import com.JWT.demo.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UsersRepo repo;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    AuthenticationManager authManager;

    public Users register(Users user) {
        //save karne ke pehele
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }

    public String verify(Users user) {

        try {
            Authentication authentication = authManager
                    .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
            if (authentication.isAuthenticated()) {
                return "User Authenticated";
            }
        } catch (Exception e) {
            return "User not Authenticated";
        }
        return "Auth failed";
    }
}
