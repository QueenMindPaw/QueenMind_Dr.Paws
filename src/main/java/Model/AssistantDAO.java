package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AssistantDAO {
    private Connection connection;

    public AssistantDAO() {
        try {
            connection = DBConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Assistant> getAllAssistants() {
        List<Assistant> assistants = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Assistants");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("assis_id");
                int personId = resultSet.getInt("per_id");

                Assistant assistant = new Assistant(id, personId);
                assistants.add(assistant);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return assistants;
    }

    // Implement other methods such as getById(), save(), update(), delete(), etc.
}
