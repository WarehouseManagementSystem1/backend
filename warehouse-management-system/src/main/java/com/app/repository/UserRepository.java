package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.User;

public interface UserRepository extends JpaRepository<User,Long> {
//add a finder method for emp auth
	Optional<User> findByEmailAndPassword(String em,String pass);
}
