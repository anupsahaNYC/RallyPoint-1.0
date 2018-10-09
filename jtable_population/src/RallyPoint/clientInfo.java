/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RallyPoint;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author anup
 */
public class clientInfo {
    
    public ResultSet clientList(int id) throws SQLException
    {
        dbConnection con = new dbConnection();
        Connection connection = con.dbConnection();
       
        
       String query = "Select * from Student where Permit_number = ?";        
       
       PreparedStatement ps = connection.prepareStatement(query);
       ps.setInt(1, id);
       ResultSet rs = ps.executeQuery( );
       connection.close();
       
       return rs;
       
    }
    
}

    

