package com.example.demo.Repository;

import com.example.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

    public Optional<User> findByEmail(String email);
}
