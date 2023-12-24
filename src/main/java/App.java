import flyway.FlywayMigration;
import jdbc.DBConnection;
import jdbc.DBRequest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException, IOException {
        FlywayMigration.migration();
        // Connection connection = DBConnection.getInstance().getConnection();
        //DBRequest.request(connection);
    }
}
