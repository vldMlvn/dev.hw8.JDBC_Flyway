package flyway;

import org.flywaydb.core.Flyway;

public class FlywayMigration {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/OSBB_v4";
    private static final String USERMNAME = "root";
    private static final String PASSWORD = "pika10f97g";

    public static void migration() {
        Flyway flyway = Flyway.configure()
                .dataSource(JDBC_URL, USERMNAME, PASSWORD)
                .locations("classpath:db/migration")
                .load();

        flyway.migrate();

    }
}