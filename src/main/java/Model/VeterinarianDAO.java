package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VeterinarianDAO {
    private Connection connection;

    public VeterinarianDAO() {
        try {
            connection = DBConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Veterinarian> getAllVeterinarians() {
        List<Veterinarian> veterinarians = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Veterinarians");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("vet_id");
                int personId = resultSet.getInt("per_id");
                String specialization = resultSet.getString("vet_specia");

                Veterinarian veterinarian = new Veterinarian(id, personId, specialization);
                veterinarians.add(veterinarian);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return veterinarians;
    }

    // Implement other methods such as getById(), save(), update(), delete(), etc.
}
