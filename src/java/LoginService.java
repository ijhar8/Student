
import java.sql.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ijhar-A
 */
public class LoginService {
    public boolean loginCheck(String username, String password){
        String query;
        String dbUsername, dbPassword;
        boolean login = false;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ijhar", "root", "root");
            Statement stmt = (Statement) con.createStatement();
            query = "SELECT Roll_no, Password FROM student ";
            stmt.executeQuery(query);
            ResultSet rs = stmt.getResultSet();

            while(rs.next()){
                dbUsername = rs.getString("Roll_No");
                dbPassword = rs.getString("Password");

                if(dbUsername.equals(username) && dbPassword.equals(password)){
                    //System.out.println("OK");
                    login = true;
                }
                //System.out.println(username + password + " " + dbUsername + dbPassword);
            }
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
        }
        return login;
    }
    
}
