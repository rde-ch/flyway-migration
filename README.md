# Flyway Migration

This repo is for migration via Flyway Technology

Flyway automates and manages your database changes, ensuring your schema evolves smoothly as your application does. It works by scanning your application's classpath or filesystem for migration scripts written in SQL, Java, or other scripting languages.

**Initial Setup and History**
Migrations are applied sequentially based on their version number.
A special table, called flyway_schema_history, acts as a log to track exactly which migrations have been applied to the database. 

**Migrating to Newer Versions**
When you need to update your database (e.g., add a new table or column), you simply add a new migration file to your project.
Flyway compares the migrations it finds on disk with the entries in the flyway_schema_history table.
Migrations with a version number lower than the database's current version are ignored.
The remaining scripts, known as "pending migrations," are then applied in order. 

**Key Benefits**
Every time you update your database structure (DDL) or data (DML), you just create a new migration file.
Flyway handles finding and running only the necessary pending migrations to bring your database up to date.
For major databases like MySQL, Oracle, PostgreSQL, and SQL Server, Flyway can capture the entire database state as a "schema model" on disk. This model can be committed to version control, giving you a history of how every object has changed over time. 
