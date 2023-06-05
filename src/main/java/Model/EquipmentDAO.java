package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EquipmentDAO {
    private Connection connection;

    public EquipmentDAO() {
        try {
            connection = DBConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Equipment> getAllEquipments() {
        List<Equipment> equipments = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Equipment");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("equip_id");
                String name = resultSet.getString("equip_name");
                String description = resultSet.getString("equip_description");
                int quantity = resultSet.getInt("equip_quantity");
                int price = resultSet.getInt("equip_price");

                Equipment equipment = new Equipment(id, name, description, quantity, price);
                equipments.add(equipment);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return equipments;
    }

    // Implement other methods such as getById(), save(), update(), delete(), etc.

    public Equipment getEquipmentById(int id) {
        Equipment equipment = null;

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Equipment WHERE equip_id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("equip_name");
                String description = resultSet.getString("equip_description");
                int quantity = resultSet.getInt("equip_quantity");
                int price = resultSet.getInt("equip_price");

                equipment = new Equipment(id, name, description, quantity, price);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return equipment;
    }

    public String getEquipmentNameById(int id) {
        String name = null;

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT equip_name FROM Equipment WHERE equip_id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                name = resultSet.getString("equip_name");
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return name;
    }

    public int getEquipmentQuantityById(int id) {
        int quantity = 0;

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT equip_quantity FROM Equipment WHERE equip_id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                quantity = resultSet.getInt("equip_quantity");
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return quantity;
    }

    public int getEquipmentPriceById(int id) {
        int price = 0;

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT equip_price FROM Equipment WHERE equip_id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                price = resultSet.getInt("equip_price");
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return price;
    }

    public void updateEquipmentQuantityById(int id, int quantity) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE Equipment SET equip_quantity = ? WHERE equip_id = ?");
            statement.setInt(1, quantity);
            statement.setInt(2, id);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEquipmentPriceById(int id, int price) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE Equipment SET equip_price = ? WHERE equip_id = ?");
            statement.setInt(1, price);
            statement.setInt(2, id);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEquipmentNameById(int id, String name) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE Equipment SET equip_name = ? WHERE equip_id = ?");
            statement.setString(1, name);
            statement.setInt(2, id);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEquipmentDescriptionById(int id, String description) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE Equipment SET equip_description = ? WHERE equip_id = ?");
            statement.setString(1, description);
            statement.setInt(2, id);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEquipmentById(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM Equipment WHERE equip_id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void saveEquipment(Equipment equipment) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO Equipment (equip_name, equip_description, equip_quantity, equip_price) " +
                            "VALUES (?, ?, ?, ?)"
            );

            statement.setString(1, equipment.getName());
            statement.setString(2, equipment.getDescription());
            statement.setInt(3, equipment.getQuantity());
            statement.setInt(4, equipment.getPrice());

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
