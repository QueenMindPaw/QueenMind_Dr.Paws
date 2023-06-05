package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OwnerDAO {
    private Connection connection;

    public OwnerDAO() {
        try {
            connection = DBConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Owner> getAllOwners() {
        List<Owner> owners = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Owner");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("own_id");
                int personId = resultSet.getInt("per_id");

                Owner owner = new Owner(id, personId);
                owners.add(owner);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return owners;
    }

    // Implement other methods such as getById(), save(), update(), delete(), etc.
}
