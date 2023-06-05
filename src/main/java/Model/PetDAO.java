package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PetDAO {
    private Connection connection;

    public PetDAO() {
        try {
            connection = DBConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Pet> getAllPets() {
        List<Pet> pets = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Pet");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("pet_id");
                int ownerId = resultSet.getInt("own_id");
                String name = resultSet.getString("pet_name");
                String species = resultSet.getString("pet_specie");
                String breed = resultSet.getString("pet_breed");
                int age = resultSet.getInt("pet_age");
                String gender = resultSet.getString("pet_gender");

                Pet pet = new Pet(id, ownerId, name, species, breed, age, gender);
                pets.add(pet);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pets;
    }

    public int getPetIdByOwnerId(int ownerId) {
        int petId = -1;

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT pet_id FROM Pet WHERE own_id = ?");
            statement.setInt(1, ownerId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                petId = resultSet.getInt("pet_id");
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return petId;
    }

    public int getOwnerIdByPetId(int petId) {
        int ownerId = -1;

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT own_id FROM Pet WHERE pet_id = ?");
            statement.setInt(1, petId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                ownerId = resultSet.getInt("own_id");
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ownerId;
    }
}
