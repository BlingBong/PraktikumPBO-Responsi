package Model;

import Database.DBConnect;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EditModel {
    public void updateData(String[] data){
        DBConnect connect = new DBConnect();
        try {
            String query = ("UPDATE karyawan SET nama = ?, usia = ?, gaji = ? WHERE id = ?");
            PreparedStatement preparedStatement = connect.connection.prepareStatement(query);
            preparedStatement.setString (1, String.valueOf(data[1]));
            preparedStatement.setString (2, String.valueOf(data[2]));
            preparedStatement.setString (3, String.valueOf(data[3]));
            preparedStatement.setString (4, String.valueOf(data[0]));
            preparedStatement.execute();
            preparedStatement.close();
            JOptionPane.showMessageDialog(null, "Update Data Berhasil");
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void hapusData(String[] data){
        DBConnect connect = new DBConnect();
        try {
            String query = ("DELETE FROM karyawan WHERE id = ?");
            PreparedStatement preparedStatement = connect.connection.prepareStatement(query);
            preparedStatement.setString (1, String.valueOf(data[0]));
            preparedStatement.execute();
            preparedStatement.close();
            JOptionPane.showMessageDialog(null, "Hapus Data Berhasil");
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
