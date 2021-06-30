package Model;

import Database.DBConnect;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OutputModel {
    public String[][] outputData() {
        DBConnect connect = new DBConnect();
        ResultSet resultSet;
        String[][] data = new String[100][6];
        try {
            connect.statement = connect.connection.createStatement();
            resultSet = connect.statement.executeQuery("SELECT * FROM karyawan");

            int i = 0;
            while(resultSet.next()){
                data[i][0] = resultSet.getString("id");
                data[i][1] = resultSet.getString("nama");
                data[i][2] = resultSet.getString("usia");
                data[i][3] = resultSet.getString("gaji");
                i++;
            }
            connect.statement.close();
            return data;
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }
}
