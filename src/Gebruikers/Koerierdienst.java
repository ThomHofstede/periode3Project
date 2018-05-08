
package Gebruikers;

import Database.MysqlConnect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Olink
 */
public class Koerierdienst extends Gebruiker {
    private String gebruikersnaam;
    private String koerierstatus;

    public Koerierdienst() {
    }
    
    public boolean controleerRol(String gebruikersnaam) {
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
              String k = rs.getString("koerierstatus");
              
              if (g.equals(gebruikersnaam)) {
                  this.koerierstatus = k;
                  this.gebruikersnaam = gebruikersnaam;
                  return true;
              }
          }
          
          
        }
        catch (Exception e) {
        System.err.println(e.getMessage());
    }  
        return false;
    }
    
    public String getKoerierstatus() {
        return this.koerierstatus;
    }
    
    public void setKoerierstatus(String koerierstatus) {
        this.koerierstatus = koerierstatus;
    }
    
    
}
