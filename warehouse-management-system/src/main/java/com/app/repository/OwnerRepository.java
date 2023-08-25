package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
	Optional<Owner> findById(Long id);
}
