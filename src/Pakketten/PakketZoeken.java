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
import java.sql.*;
  
        
public class PakketZoeken {
   /* private int pakketId;
    private String statusBeschrijving;
    private String pakketStatus;
*/
    
    
 
    public void zoekPakket() {
        
        try {
            
            Connection conn = DriverManager.getConnection("jdbc:mysql:localhost/projectJava");
            
            Statement stmt = (Statement) conn.createStatement();
            
            String eind = "Alkmaar";
            String begin = "Amsterdam";
            String datum = "00-00-00";
            
            String query = "SELECT * FROM pakketlevering WHERE vertrekstation =  " + "'" + begin + "'" +  "OR aankomststation = " + "'" + eind + "'" + "OR deadline LIKE "+ "'" + datum + "%';";
            
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                System.out.println("test" + rs.getString(begin));
                System.out.println(rs.getString(eind));
                System.out.println(rs.getString(datum));
            }
            
        }catch(SQLException exc) {
            System.out.println("Fout: " + exc.getMessage());
        }
    }
}
