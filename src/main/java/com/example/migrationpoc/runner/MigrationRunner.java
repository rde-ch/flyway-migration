package com.example.migrationpoc.runner;

import com.example.migrationpoc.service.FlywayMigrationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MigrationRunner implements CommandLineRunner {
//    @Value("${app.active-schema}")
//    private String activeSchema;

    private final FlywayMigrationService flywayMigrationService;

    public MigrationRunner(FlywayMigrationService flywayMigrationService) {
        this.flywayMigrationService = flywayMigrationService;
    }
    @Override
    public void run(String... args) throws Exception {
        String activeSch = System.setProperty("app.active_schema", "addressmig_blue");
        flywayMigrationService.migrateRollback(activeSch);
    }
}
