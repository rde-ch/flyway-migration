package com.example.migrationpoc;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("green")
public class FlywayMigrationTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //@Test
    void migrationRunSuccessfully()  {
        Integer count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM addressmig_green.flyway_schema_history",
                Integer.class);
        assertTrue(count > 0);
    }

   // @Test
    void dpaTableShouldExists() {
        Integer exists = jdbcTemplate.queryForObject("""
                SELECT COUNT(*) FROM information_schema.tables where table_schema ='addressmig_green'
                AND table_name = 'dpa'""", Integer.class);
        assertEquals(1, exists);
    }

    //@Test
    void dataShouldExists() {
        Integer count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM addressmig_green.dpa_backup",
                Integer.class);
        assertTrue(count > 1000);
    }

  //  @Test
    void backupTableShouldBeActive() {
        Integer count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM addressmig_green.dpa_backup",
                Integer.class);
        assertTrue(count > 0);
    }
}
