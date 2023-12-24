package flyway;

import org.flywaydb.core.Flyway;
import password_encryption.CustomEncryptor;

public class FlywayMigration {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/OSBB_v5";
    private static final String USERMNAME = "root";
    private static final String PASSWORD = "0xE11700x11000x11200x10200x5400x5300x10700x6200x6000x10800xWw";

    private FlywayMigration(){}

    public static void migration() {
        Flyway flyway = Flyway.configure()
                .dataSource(JDBC_URL, USERMNAME, CustomEncryptor.decrypt(PASSWORD))
                .locations("classpath:db/migration")
                .load();

        flyway.migrate();

    }
}