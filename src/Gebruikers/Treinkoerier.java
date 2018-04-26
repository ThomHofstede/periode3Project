
package Gebruikers;

import project.MysqlConnect;
import Gebruikers.Gebruiker;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Olink
 */
public class Treinkoerier extends Gebruiker {
    private String gebruikersnaam;
    private String wachtwoord;
    private String voornaam;
    private String achternaam;
    private int telefoonnr;

    public Treinkoerier(String gebruikersnaam, String wachtwoord) {
        super(gebruikersnaam, wachtwoord);
        
        this.gebruikersnaam = gebruikersnaam;
        this.wachtwoord = wachtwoord;
        
        MysqlConnect dbconn = new MysqlConnect();
        
        try {
        // create our mysql database connection
          Connection conn = dbconn.connect();

          // our SQL SELECT query. 
          // if you only need a few columns, specify them by name instead of using "*"
          String query = "SELECT * FROM Treinkoerier";

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
              }
          }
          
          
        }
        catch (Exception e) {
        System.err.println(e.getMessage());
    }  
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
