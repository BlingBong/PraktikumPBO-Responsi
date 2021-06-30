package Model;

import Database.DBConnect;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InputModel {
    public void inputData(String[] data){
        DBConnect connect = new DBConnect();
        try {
            String query = ("INSERT INTO karyawan (id, nama, usia, gaji) values (id, ?, ?, ?)");
            PreparedStatement preparedStatement = connect.connection.prepareStatement(query);
            preparedStatement.setString (1, String.valueOf(data[0]));
            preparedStatement.setString (2, String.valueOf(data[1]));
            preparedStatement.setString (3, String.valueOf(data[2]));
            preparedStatement.execute();
            preparedStatement.close();
            JOptionPane.showMessageDialog(null, "Input Data Berhasil");
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
