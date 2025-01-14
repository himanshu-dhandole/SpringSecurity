package com.JWT.demo.service;

import com.JWT.demo.model.Users;
import com.JWT.demo.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UsersRepo repo;

    @Autowired
    private PasswordEncoder encoder ;

    public Users register(Users user) {
        //save karne ke pehele
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user) ;
    }
}
