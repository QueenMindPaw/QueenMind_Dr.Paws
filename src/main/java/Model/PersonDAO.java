package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO {
    private Connection connection;

    public PersonDAO(Connection connection) {
        this.connection = connection;
    }

    public PersonDAO() {
        try {
            connection = DBConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<person> getAllPersons() {
        List<person> persons = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Person");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("per_id");
                String name = resultSet.getString("per_name");
                String appat = resultSet.getString("per_appat");
                String ammat = resultSet.getString("per_ammat");
                String email = resultSet.getString("per_email");
                String password = resultSet.getString("per_password");

                person person = new person(id, name, appat, ammat, email, password);
                persons.add(person);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return persons;
    }

    // Metodos CRUD (Create, Read, Update, Delete)
    public person getPersonById(int id) {
        person person = null;

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Person WHERE per_id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("per_name");
                String appat = resultSet.getString("per_appat");
                String ammat = resultSet.getString("per_ammat");
                String email = resultSet.getString("per_email");
                String password = resultSet.getString("per_password");

                person = new person(id, name, appat, ammat, email, password);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return person;
    }


    public person savePerson(person person) {
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Person (per_name, per_appat, per_ammat, per_email, per_password) VALUES (?, ?, ?, ?, ?)");
            statement.setString(1, person.getName());
            statement.setString(2, person.getAppat());
            statement.setString(3, person.getAmmat());
            statement.setString(4, person.getEmail());
            statement.setString(5, person.getPassword());
            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();

            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                person.setId(id);
            }

            resultSet.close();
            statement.close();
            DBConnection.closeConnection(); // Close the connection

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return person;
    }

    public person updatePerson(person person) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE Person SET per_name = ?, per_appat = ?, per_ammat = ?, per_email = ?, per_password = ? WHERE per_id = ?");
            statement.setString(1, person.getName());
            statement.setString(2, person.getAppat());
            statement.setString(3, person.getAmmat());
            statement.setString(4, person.getEmail());
            statement.setString(5, person.getPassword());
            statement.setInt(6, person.getId());
            statement.executeUpdate();

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return person;
    }

    public boolean deletePerson(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM Person WHERE per_id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public person getPersonByEmail(String email) {
            person person = null;

            try {
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM Person WHERE per_email = ?");
                statement.setString(1, email);
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    int id = resultSet.getInt("per_id");
                    String name = resultSet.getString("per_name");
                    String appat = resultSet.getString("per_appat");
                    String ammat = resultSet.getString("per_ammat");
                    String password = resultSet.getString("per_password");

                    person = new person(id, name, appat, ammat, email, password);
                }

                resultSet.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return person;
        }

}
