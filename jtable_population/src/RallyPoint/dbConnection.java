/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RallyPoint;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author anup
 */
public class dbConnection {
    
    public static Connection dbConnection() throws SQLException
    {
        Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/bds?user=root&password=saha2314");
        
        return connection;
    }
    
}
