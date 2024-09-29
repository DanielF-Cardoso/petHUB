package br.com.pethub.jdbc;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.output.MigrateResult;
import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * This class is responsible for managing the Flyway database migration.
 * It reads the database configuration from a properties file and uses it to establish a connection and perform the migration.
 *
 * @author Daniel Fernandes
 */
public class FlywayMigration {

    /**
     * The main method that initiates the Flyway migration process.
     * It reads the database configuration from a properties file, establishes a connection, and performs the migration.
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        try {

            InputStream input = FlywayMigration.class.getClassLoader().getResourceAsStream("config.properties");
            if (input == null) {
                throw new IOException("Configuration file was not found");
            }

            Properties prop = new Properties();
            prop.load(input);

            String host = prop.getProperty("host");
            String port = prop.getProperty("port");
            String database = prop.getProperty("database");
            String username = prop.getProperty("username");
            String password = prop.getProperty("password");

            String url = "jdbc:mysql://" + host + ":" + port + "/" + database;

            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                if (conn != null) {
                    System.out.println("Successfully connected to the database.");
                }
            }

            Flyway flyway = Flyway.configure()
                    .dataSource(url, username, password)
                    .locations("filesystem:src/main/resources/db/migration")
                    .load();

            MigrateResult result = flyway.migrate();
            System.out.println("Migration completed successfully.");
            System.out.println("Migrations applied: " + result.migrationsExecuted);
            result.migrations.forEach(migration -> {
                System.out.println("Migration: " + migration.version + " - " + migration.description);
            });

        } catch (IOException e) {
            System.err.println("An error occurred while loading the configuration file: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}