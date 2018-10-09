/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RallyPoint;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author anup
 */
public class studentList {
    public ResultSet rs;
    public ResultSet studentList(){
        
        try{
        dbConnection con = new dbConnection();
        Connection connection = con.dbConnection();
        String query = "Select lname, fname, Phone, Address, Permit_number from Student ORDER BY lname";
        
       Statement st = connection.createStatement();
       rs = st.executeQuery(query);
       connection.close();
       
       
       
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Connection has failed, alter settings or call Anup");
            System.exit(0);
        }
        
        return rs;
    }
    
}
