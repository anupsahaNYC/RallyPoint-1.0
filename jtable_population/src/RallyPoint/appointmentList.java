/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RallyPoint;

import java.sql.*;

/**
 *
 * @author anup
 */
public class appointmentList {
    
    public ResultSet appointmentList(int id) throws SQLException
    {
        dbConnection con = new dbConnection();
        Connection connection = con.dbConnection();
       
        
       String query = "Select DATE_FORMAT(Appointment_Date, '%m/%d/%Y'), DATE_FORMAT(Appointment_Time, '%r'), Instructor, Service_Code, Price, Amount_Paid, Receipt_Number, DoHide from Appointments where Permit_number = ? ORDER BY Appointment_Date";        
       
       PreparedStatement ps = connection.prepareStatement(query);
       ps.setInt(1, id);
       ResultSet rs = ps.executeQuery( );
       connection.close();
       
       return rs;
       
    }
    
}
