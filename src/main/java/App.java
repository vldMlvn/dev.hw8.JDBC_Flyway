import flyway.FlywayMigration;
import jdbc.DBConnection;
import jdbc.DBRequest;

import java.sql.Connection;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {
        FlywayMigration.migration();
        Connection connection = DBConnection.getInstance().getConnection();
        DBRequest.request(connection);
    }
}
