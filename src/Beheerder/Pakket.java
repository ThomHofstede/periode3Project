/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beheerder;

import Database.MysqlConnect;
import Schermen.PakketlijstDashboard;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author thomhofstede
 */
public class Pakket {

    private static double price;
    private static Boolean isGreen;
    
    public static boolean create(ArrayList from, ArrayList to, double costs){
        MysqlConnect dbconnection = new MysqlConnect();
        dbconnection.connect();
        Random generator = new Random(); 
        int orderID = 0;
        
        try
        {
            
            if(orderID == 0){
                orderID = generator.nextInt(100000);
            }
            
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            // pakket record
            try ( // create our mysql database connection
                Connection conn = dbconnection.connect()) {                
                LocalDate deadline = LocalDate.now().plusDays(2);
                // pakket record
                String query = "INSERT INTO pakket VALUES ("+orderID+", \"aangemaakt\", NULL, \" "+from.get(0)+"\", \""+to.get(2)+"\", \""+deadline+"\", 0,0,"+Pakket.isGreen+", \""+from.get(1) + "\"  \"" + from.get(2) + "\"  \"" +  from.get(0)+"\", \""+to.get(0) + "\"  \"" + to.get(1) + "\"  \"" +  to.get(2)+"\")";
                Statement st = conn.createStatement();
                int rs = st.executeUpdate(query);
                
                //pakket levering record
                String query2 = "INSERT INTO pakketlevering VALUES ("+orderID+", \"NULL\", \"test\", \"3.50\", "+costs+")";
                Statement st2 = conn.createStatement();
                int rs2 = st.executeUpdate(query2);
            }
            orderID = 0;
            
           
            return true;
           
        }catch (SQLException e){
          System.err.println("Got an exception! ");
          System.err.println(e.getMessage());
          return false;
        }
    }
    
    public static void setIsGreen(Boolean value){
        isGreen = value;
    }
    
    public static Boolean getGreen(){
        return isGreen;
    }
    
    public static ResultSet getAll(){
        try {
            MysqlConnect dbconn = new MysqlConnect();

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDateTime now = LocalDateTime.now();
            Date currentdate = new Date(dtf.format(now));
            // create our mysql database connection
            Connection conn = dbconn.connect();

            // our SQL SELECT query. 
            String query = "SELECT * FROM pakketlevering pl INNER JOIN pakket p ON pl.`pakketid` = p.`pakketid`";

            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);
            
            return rs;
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
