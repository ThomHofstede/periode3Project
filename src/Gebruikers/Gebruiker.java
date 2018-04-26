
package Gebruikers;

import project.MysqlConnect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Olink
 */
public class Gebruiker {
    private String gebruikersnaam;
    private String wachtwoord;
    
    public Gebruiker(String gebruikersnaam, String wachtwoord) {
        MysqlConnect dbconn = new MysqlConnect();
        
        try {
        // create our mysql database connection
          Connection conn = dbconn.connect();

          // our SQL SELECT query. 
          // if you only need a few columns, specify them by name instead of using "*"
          String query = "SELECT * FROM Gebruiker";

          // create the java statement
          Statement st = conn.createStatement();

          // execute the query, and get a java resultset
          ResultSet rs = st.executeQuery(query);
          
          while (rs.next()) {
              String g = rs.getString("gebruikersnaam");
              String w = rs.getString("wachtwoord");
              
              if (g.equals(gebruikersnaam) && w.equals(wachtwoord)) {
                  this.gebruikersnaam = g;
                  this.wachtwoord = w;
              }
          }
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
    }
    
    public String getGebruikersnaam() {
        return this.gebruikersnaam;
    }
    
    public String getWachtwoord() {
        return this.wachtwoord;
    }
}
