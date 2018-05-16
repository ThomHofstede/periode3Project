/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pakketten;

/**
 *
 * @author tomde
 */
import Database.MysqlConnect;
import java.sql.*;
import java.util.Scanner;
  
        
public class PakketZoeken {
   /* private int pakketId;
    private String statusBeschrijving;
    private String pakketStatus;
*/
    
    
 
    public void zoekPakket() {
        
        try {
            
            Connection conn = DriverManager.getConnection("jdbc:mysql:localhost/projectJava");
            
            Statement stmt = (Statement) conn.createStatement();
            
            String eind = "";
            String begin = "";
            String datum = "";
            
            String query = "SELECT * FROM Pakketlevering WHERE vertrekstation = '" + begin + "' AND aankomststation = '" + eind + "' AND deadline = '" + datum + "';";
            
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                System.out.println(rs.getString(begin));
                System.out.println(rs.getString(eind));
                System.out.println(rs.getString(datum));
            }
            
        }catch(Exception exc) {
            System.out.println("Fout: " + exc.getMessage());
        }
    }
}
