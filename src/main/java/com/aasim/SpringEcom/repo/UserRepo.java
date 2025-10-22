package com.aasim.SpringEcom.repo;

import com.aasim.SpringEcom.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
    User findByUsername(String username);



}
