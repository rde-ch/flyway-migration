package com.example.migrationpoc.service;

import com.example.migrationpoc.config.SchemaResolver;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.FlywayException;
import org.springframework.stereotype.Service;

@Service
public class FlywayMigrationService {
     public void migrateRollback(String activeSchema) {
         String targetSchema = SchemaResolver.getTargetSchema(activeSchema);
         System.out.println("Active schema: " + activeSchema);
         System.out.println("Target schema: " + targetSchema);

         Flyway flyway = Flyway.configure().dataSource("jdbc:postgresql://localhost:5433/migrationdb","postgres",
                 "postgres")
                 .defaultSchema(targetSchema)
                 .schemas(targetSchema)
                 .table("flyway_schema_history")
                 .locations("classpath:db/migration-" + targetSchema)
                 .baselineOnMigrate(true)
                 .load();

         try {
             System.out.println("Migration started with schema: " + targetSchema);
             flyway.migrate();
             System.out.println("Migration successful. Switching schema ");
             switchSchema(targetSchema);
         } catch (FlywayException e) {
             System.out.println("Error while migrating, Rolling back to previous schema");
             rollback(activeSchema);
             throw new RuntimeException("Migration failed and rollback executed", e);
         }
         }

     private void switchSchema(String newSchema) {
        System.setProperty("app.active.schema", newSchema);
        System.out.println("Switching to schema: " + newSchema);
     }

     private void rollback(String prevSchema) {
         System.out.println("Reverting to  previous schema: " + prevSchema);
         System.setProperty("app.active.schema", prevSchema);
     }
}
