
package Gebruikers;

import Database.MysqlConnect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Olink
 */
public class Fietskoerier {
    private String gebruikersnaam;
    private String voornaam;
    private String achternaam;
    private int telefoonnr;
    
    public boolean controleerRol(String gebruikersnaam) {
        MysqlConnect dbconn = new MysqlConnect();
        
        try {
        // create our mysql database connection
          Connection conn = dbconn.connect();

          // our SQL SELECT query. 
          // if you only need a few columns, specify them by name instead of using "*"
          String query = "SELECT * FROM Fietskoerier";

          // create the java statement
          Statement st = conn.createStatement();

          // execute the query, and get a java resultset
          ResultSet rs = st.executeQuery(query);
          
          while (rs.next()) {
              String g = rs.getString("gebruikersnaam");
              String v = rs.getString("voornaam");
              String a = rs.getString("achternaam");
              int telnr = rs.getInt("telefoonnr");
              
              if (g.equals(gebruikersnaam)) {
                  this.voornaam = v;
                  this.achternaam = a;
                  this.telefoonnr = telnr;
                  return true;
              }
          }
          
          
        }
        catch (Exception e) {
        System.err.println(e.getMessage());
    }  
        return false;
    }
    
    public String getVoornaam() {
        return this.voornaam;
    }
    
    public String getAchternaam() {
        return this.achternaam;
    }
    
    public int getTelefoonnr() {
        return this.telefoonnr;
    }
}
