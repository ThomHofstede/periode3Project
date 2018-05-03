
package Gebruikers;

import Database.MysqlConnect;
import Gebruikers.Gebruiker;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Olink
 */
public class Koerierdienst extends Gebruiker {
    private String gebruikersnaam;
    private String wachtwoord;
    private String bedrijfnaam;
    private String koerierstatus;
    private int telefoonnr;

    public Koerierdienst(String gebruikersnaam, String wachtwoord) {
        super(gebruikersnaam, wachtwoord);
        
        this.gebruikersnaam = gebruikersnaam;
        this.wachtwoord = wachtwoord;
        
        MysqlConnect dbconn = new MysqlConnect();
        
        try {
        // create our mysql database connection
          Connection conn = dbconn.connect();

          // our SQL SELECT query. 
          // if you only need a few columns, specify them by name instead of using "*"
          String query = "SELECT * FROM Koerierdienst";

          // create the java statement
          Statement st = conn.createStatement();

          // execute the query, and get a java resultset
          ResultSet rs = st.executeQuery(query);
          
          while (rs.next()) {
              String g = rs.getString("gebruikersnaam");
              String bn = rs.getString("bedrijfnaam");
              String k = rs.getString("koerierstatus");
              int telnr = rs.getInt("telefoonnr");
              
              if (g.equals(gebruikersnaam)) {
                  this.bedrijfnaam = bn;
                  this.koerierstatus = k;
                  this.telefoonnr = telnr;
              }
          }
          
          
        }
        catch (Exception e) {
        System.err.println(e.getMessage());
    }  
    }
    
    public String getBedrijfnaam() {
        return this.bedrijfnaam;
    }
    
    public String getKoerierstatus() {
        return this.koerierstatus;
    }
    
    public void setKoerierstatus(String koerierstatus) {
        this.koerierstatus = koerierstatus;
    }
    
    public int getTelefoonnr() {
        return this.telefoonnr;
    }
    
}
