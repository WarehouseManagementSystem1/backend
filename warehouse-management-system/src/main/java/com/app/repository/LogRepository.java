package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Log;

public interface LogRepository extends JpaRepository<Log, Long> {

}
