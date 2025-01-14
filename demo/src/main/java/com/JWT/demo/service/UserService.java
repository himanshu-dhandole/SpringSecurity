package com.JWT.demo.service;

import com.JWT.demo.model.UserPrincipal;
import com.JWT.demo.model.Users;
import com.JWT.demo.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
public class UserService implements UserDetailsService {


    @Autowired
    private UsersRepo usersRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = usersRepo.getByUsername(username) ;

        if (user == null) {
            System.out.println("user not found // ");
            throw new UsernameNotFoundException("User not found") ;
        }

        return new UserPrincipal(user);
    }
}
