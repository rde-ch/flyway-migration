package com.example.migrationpoc.controller;

import com.example.migrationpoc.domain.Dpa;
import com.example.migrationpoc.service.FlywayAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
@RequiredArgsConstructor
public class FlywayMigrationController {

    private final FlywayAddressService flywayAddressService;

    @PostMapping
    public Dpa createDpaAddress(@RequestBody Dpa address) {
        return flywayAddressService.saveDpa(address);
    }

    @GetMapping
    public List<Dpa> getAllDpaAddresses() {
        return flywayAddressService.findAllDpa();
    }
}

