package progect;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class dbconect {

    private Statement s;

    public dbconect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/projectdb", "root", "");
            s = con.createStatement();
            s.executeUpdate("CREATE DATABASE IF NOT EXISTS projectdb");
            s.executeUpdate("USE projectdb");
            s.executeUpdate("CREATE TABLE IF NOT EXISTS users (id INT NOT NULL AUTO_INCREMENT, username VARCHAR(255) NOT NULL, password VARCHAR(255) NOT NULL, phone VARCHAR(255), email VARCHAR(255) NOT NULL, PRIMARY KEY (id))");
            s.executeUpdate("CREATE TABLE IF NOT EXISTS patients (name VARCHAR(255), pct INTEGER);");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }

    public void addUser(String username, String password, String contact, String email) {
        try {
            s.executeUpdate("INSERT INTO users (username,password,email,phone) VALUES ('" + username + "','" + password + "','" + email + "','" + contact + "');");
        } catch (SQLException ex) {
            Logger.getLogger(dbconect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void checkuser(String u, String p) {
        try {
            ResultSet rs = s.executeQuery("select*from users");
            int flg = 1;
            int hip=1;
            while (rs.next()) {
                String username = rs.getString(2);
                String Password = rs.getString(3);
                if (u.equals(username) && p.equals(Password)) {

                    flg = 0;
                    break;
                }
                else if(u.equals(username))
                {
                    hip=0;
                }
            }
            if (flg == 1) {
                if(hip==0){
                JOptionPane.showMessageDialog(null, "Please enter a correct password");
                 new login();
                }
                else
                {
                   JOptionPane.showMessageDialog(null, "Please enter correct information");
                   new login();
                }
            } else {
                new home();
            }

        } catch (SQLException ex) {
            Logger.getLogger(dbconect.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void addPatient(String name, int pct){
        try{
            s.executeUpdate(String.format("INSERT INTO patients VALUES ('%s',%s)",name,pct));
        }catch(SQLException e){
            System.out.println("hi");
        }
    }
    public ResultSet getList() throws SQLException{
     
        return s.executeQuery("SELECT * From patients");
        
    }
}
