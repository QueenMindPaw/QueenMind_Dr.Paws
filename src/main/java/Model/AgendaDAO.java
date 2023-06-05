package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AgendaDAO {
    private Connection connection;

    public AgendaDAO() {
        try {
            connection = DBConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Agenda> getAllAgendas() {
        List<Agenda> agendas = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Agenda");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("appo_id");
                int petId = resultSet.getInt("pet_id");
                int vetId = resultSet.getInt("vet_id");
                int assistantId = resultSet.getInt("assis_id");
                // Assuming the datetime is stored as a string in the database
                String datetime = resultSet.getString("appo_datetime");

                Agenda agenda = new Agenda(id, petId, vetId, assistantId, datetime);
                agendas.add(agenda);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return agendas;
    }

    // Implement other methods such as getById(), save(), update(), delete(), etc.

    public List<Agenda> getAgendaByPetId(int petId) {
        List<Agenda> agendas = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Agenda WHERE pet_id = ?");
            statement.setInt(1, petId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("appo_id");
                int vetId = resultSet.getInt("vet_id");
                int assistantId = resultSet.getInt("assis_id");
                // Assuming the datetime is stored as a string in the database
                String datetime = resultSet.getString("appo_datetime");

                Agenda agenda = new Agenda(id, petId, vetId, assistantId, datetime);
                agendas.add(agenda);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return agendas;
    }

    public List<Agenda> getAgendaByVetId(int vetId) {
        List<Agenda> agendas = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Agenda WHERE vet_id = ?");
            statement.setInt(1, vetId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("appo_id");
                int petId = resultSet.getInt("pet_id");
                int assistantId = resultSet.getInt("assis_id");
                // Assuming the datetime is stored as a string in the database
                String datetime = resultSet.getString("appo_datetime");

                Agenda agenda = new Agenda(id, petId, vetId, assistantId, datetime);
                agendas.add(agenda);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return agendas;
    }

    public List<Agenda> getAgendaByAssistantId(int assistantId) {
        List<Agenda> agendas = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Agenda WHERE assis_id = ?");
            statement.setInt(1, assistantId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("appo_id");
                int petId = resultSet.getInt("pet_id");
                int vetId = resultSet.getInt("vet_id");
                // Assuming the datetime is stored as a string in the database
                String datetime = resultSet.getString("appo_datetime");

                Agenda agenda = new Agenda(id, petId, vetId, assistantId, datetime);
                agendas.add(agenda);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return agendas;
    }

    public List<Agenda> getAgendaByDatetime(String datetime) {
        List<Agenda> agendas = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Agenda WHERE appo_datetime = ?");
            statement.setString(1, datetime);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("appo_id");
                int petId = resultSet.getInt("pet_id");
                int vetId = resultSet.getInt("vet_id");
                int assistantId = resultSet.getInt("assis_id");

                Agenda agenda = new Agenda(id, petId, vetId, assistantId, datetime);
                agendas.add(agenda);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return agendas;
    }
}
