package com.example.migrationpoc.repository;

import com.example.migrationpoc.domain.Dpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlywayDpaRepository extends JpaRepository<Dpa, Long> {
}
