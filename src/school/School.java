package school;

import com.mysql.jdbc.Statement;
import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;

import javax.swing.*;

public class School {

    static Connection con;
    static Statement stmt;
    static String user = null, pass = null;
    static login log = new login();

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        getUserPass();

        log.setVisible(true);

    }

    static void getUserPass() throws SQLException, ClassNotFoundException {

        try {
            String URL = "jdbc:mysql://localhost/";
            String DBName = "school";
            String driver = "com.mysql.jdbc.Driver";
            String userName = "root";
            String password = "";
            Class.forName(driver);
            con = (Connection) DriverManager.getConnection(URL + DBName, userName, password);
            Statement stmt = (Statement) con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ResultSet rs = stmt.executeQuery("select * from login");
            rs.first();
            user = rs.getString(1);
            pass = rs.getString(2);
            con.close();
        } catch (Exception e) {
        }

    }

    static void done() throws IOException {

        mainProgram mp = new mainProgram();
        if (login.username.equals(user) && login.password.equals(pass)) {
            log.setVisible(false);
            mp.setLocation(400, 200);
            mp.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "The UserName and PassWord is Wrong..!");
        }

    }
}
