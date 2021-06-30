package Database;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBConnect {
    public Connection connection;
    public Statement statement;
    public DBConnect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/karyawan?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            System.out.println("Koneksi Berhasil");
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public Connection getConnection(){
        return  connection;
    }
}
