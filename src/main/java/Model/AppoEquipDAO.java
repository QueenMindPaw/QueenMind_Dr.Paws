package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AppoEquipDAO {
    private Connection connection;

    public AppoEquipDAO() {
        try {
            connection = DBConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<AppoEquip> getAllAppoEquips() {
        List<AppoEquip> appoEquips = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM appo-equip");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int appoId = resultSet.getInt("appo_id");
                int equipId = resultSet.getInt("equip_id");
                int quantity = resultSet.getInt("apeq_quantity");

                AppoEquip appoEquip = new AppoEquip(appoId, equipId, quantity);
                appoEquips.add(appoEquip);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return appoEquips;
    }


    public List<AppoEquip> getAppoEquipsByAppoId(int appoId) {
        List<AppoEquip> appoEquips = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM appo-equip WHERE appo_id = ?");
            statement.setInt(1, appoId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int equipId = resultSet.getInt("equip_id");
                int quantity = resultSet.getInt("apeq_quantity");

                AppoEquip appoEquip = new AppoEquip(appoId, equipId, quantity);
                appoEquips.add(appoEquip);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return appoEquips;
    }

    public List<AppoEquip> getAppoEquipsByEquipId(int equipId) {
        List<AppoEquip> appoEquips = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM appo-equip WHERE equip_id = ?");
            statement.setInt(1, equipId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int appoId = resultSet.getInt("appo_id");
                int quantity = resultSet.getInt("apeq_quantity");

                AppoEquip appoEquip = new AppoEquip(appoId, equipId, quantity);
                appoEquips.add(appoEquip);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return appoEquips;
    }
}
