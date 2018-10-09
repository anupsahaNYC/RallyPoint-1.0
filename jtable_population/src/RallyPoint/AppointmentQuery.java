/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RallyPoint;

import static RallyPoint.AppointmentSelector.dateFormat;
import static RallyPoint.AppointmentSelector.payments;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author anup
 */
public class AppointmentQuery {
    
    public static void AppointmentChanger(int id, String instructor, String date, String time) throws SQLException
    {
        dbConnection db = new dbConnection();
                Connection con = db.dbConnection();
                
                String query = "SELECT * from Appointments WHERE Permit_number = ? and Instructor = ? and Appointment_Date = STR_TO_DATE(?, '%d/%m/%Y') and Appointment_Time = STR_TO_DATE(?, '%l:%i %p'";
                con.close();
    }
    public static ResultSet AppointmentPull(int id, String inst, String appdate, String apptime) throws SQLException, ParseException
    {
        dbConnection db = new dbConnection();
        Connection con = db.dbConnection();
                String query = "SELECT * from Appointments WHERE Permit_number = ? and Instructor = ? and Appointment_Date = ? and Appointment_Time = ?";
        PreparedStatement ps = con.prepareStatement(query);
        SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm:ss");
       SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm:ss a");
        Date date = parseFormat.parse(apptime);
        ps.setInt(1, id);
        ps.setString(2, inst);
        ps.setString(3, dateFormat(appdate));
        ps.setString(4, displayFormat.format(date));
        
        System.out.println(ps);
        
        
        return ps.executeQuery();
        
    }
    public static void conceal(String id, String inst, String appdate, String apptime, String in) throws SQLException, ParseException
    {
        dbConnection db = new dbConnection();
        Connection connection = db.dbConnection();
        if (in == "*")
        {
        String query = "UPDATE Appointments SET DoHide = 0 WHERE Permit_number = ? and Instructor = ? and Appointment_Date = ? and Appointment_Time = ? ";
            PreparedStatement ps = connection.prepareStatement(query);
            
            //Where clauses
            ps.setString(1, id);
            ps.setString(2, inst);
            ps.setString(3, appdate);
            ps.setString(4, apptime);
            
            ps.executeUpdate();
        }
        else
        {
            String query = "UPDATE Appointments SET DoHide = 1 WHERE Permit_number = ? and Instructor = ? and Appointment_Date = ? and Appointment_Time = ? ";
            PreparedStatement ps = connection.prepareStatement(query);
            
            //Where clauses
            ps.setString(1, id);
            ps.setString(2, inst);
            ps.setString(3, appdate);
            ps.setString(4, apptime);
            
            ps.executeUpdate();
        }
    }
    public static String dateFormat(String in) {
       in = in.replaceAll("/", "");    
    String h = in.substring(4);
        
        
        in = h + in.substring(0, 4);
        System.out.println(in);
        return in;
    }

    
}
