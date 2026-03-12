package com.example.migrationpoc.service;

import com.example.migrationpoc.domain.Dpa;
import com.example.migrationpoc.repository.FlywayDpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlywayAddressService {

    private final FlywayDpaRepository flywayDpaRepository;

    public Dpa saveDpa(Dpa dpa) {
        return flywayDpaRepository.save(dpa);
    }
    public List<Dpa> findAllDpa() {
        return flywayDpaRepository.findAll();
    }

}
