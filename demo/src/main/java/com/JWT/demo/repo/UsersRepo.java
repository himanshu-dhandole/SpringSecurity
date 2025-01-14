package com.JWT.demo.repo;

import com.JWT.demo.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepo extends JpaRepository<Users,Integer> {
   Optional<Users> getByUsername(String username);
}
