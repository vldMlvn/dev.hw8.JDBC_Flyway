package jdbc;

import write_to_file.Writer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBRequest {

    private DBRequest(){}

    public static void request(Connection connection) throws SQLException, IOException {
        String selectQuery = "SELECT  " +
                "r.name AS name, " +
                "r.lastname AS lastname, " +
                "r.email AS email, " +
                "b.address AS building_address, " +
                "a.id AS apartment, " +
                "a.number_of_rooms AS number_of_rooms, " +
                "a.area AS area " +
                "FROM resident r " +
                "JOIN resident_ownership ro ON r.id = ro.resident_id " +
                "JOIN apartment a ON ro.apartment_id = a.id " +
                "JOIN building b ON a.building_id = b.id " +
                "WHERE r.car_access = 0 " +
                "AND ( " +
                "SELECT COUNT(*) " +
                "FROM resident_ownership ro2 " +
                "WHERE ro2.resident_id = r.id" +
                ") < 2 ";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectQuery);
             Writer writer = new Writer()) {

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String lastname = resultSet.getString("lastname");
                String email = resultSet.getString("email");
                String buildingAddress = resultSet.getString("building_address");
                int apartment = resultSet.getInt("apartment");
                int numbersOfRooms = resultSet.getInt("number_of_rooms");
                int area = resultSet.getInt("area");

                String result ="Name: " + name +
                        " Lastname: " + lastname +
                        " Email: " + email +
                        " Address: " + buildingAddress +
                        " Apartment: " + apartment +
                        " Numbers of rooms: " + numbersOfRooms +
                        " Area: " + area;

                writer.write(result);
                System.out.println(result);
            }
        }
    }
}
