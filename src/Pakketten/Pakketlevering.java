
package Pakketten;

import Database.MysqlConnect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Olink
 */
public class Pakketlevering {
    private int pakketid;
    private String pakketstatus;
    private String status_beschrijving;
    private String gebruikersnaam;
    private String rol;
    
    public Pakketlevering(String gebruikersnaam) {
        MysqlConnect dbconn = new MysqlConnect();
        
        try {     
        // create our mysql database connection
          Connection conn = dbconn.connect();

          // our SQL SELECT query. 
          // if you only need a few columns, specify them by name instead of using "*"
          String query = "SELECT * FROM Pakket AS p INNER JOIN Pakketlevering AS pl ON p.pakketID=pl.pakketID";

          // create the java statement
          Statement st = conn.createStatement();

          // execute the query, and get a java resultset
          ResultSet rs = st.executeQuery(query);
          
          while (rs.next()) {
              int pi = rs.getInt("pakketID");
              String ps = rs.getString("pakketstatus");
              String sb = rs.getString("status_beschrijving");
              String trein = rs.getString("treinkoerier");
              String fiets = rs.getString("fietskoerier");
              
              if (gebruikersnaam.equals(trein)) {
                  this.pakketid = pi;
                  this.pakketstatus = ps;
                  this.status_beschrijving = sb;
                  this.rol = "trein";
              }
              
              if (gebruikersnaam.equals(fiets)) {
                  this.pakketid = pi;
                  this.pakketstatus = ps;
                  this.status_beschrijving = sb;
                  this.rol = "fiets";
              }
          }
          
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void updatePakket(String rol, String pakketstatus) {
        MysqlConnect dbconn = new MysqlConnect();
        
        try {     

          Connection conn = dbconn.connect();

          if (this.rol.equals("trein")) {
          String query = "UPDATE Pakket SET pakketstatus = " + "'" + pakketstatus + " (trein)'" + " WHERE pakketID = " + "'" + pakketid + "'";
          
          Statement st = conn.createStatement();

          st.executeUpdate(query);
          }
          
          if (this.rol.equals("fiets")) {
          String query = "UPDATE Pakket SET pakketstatus = " + "'" + pakketstatus + " (fiets)'" + " WHERE pakketID = " + "'" + pakketid + "'";

          Statement st = conn.createStatement();


          st.executeUpdate(query);
          }
          
        }
          catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void updatePakket(String rol, String pakketstatus, String status_beschrijving) {
        MysqlConnect dbconn = new MysqlConnect();
        
        try {     
          Connection conn = dbconn.connect();
          
          if (this.rol.equals("fiets")) {
          String query = "UPDATE Pakket SET pakketstatus = " + "'" + pakketstatus + " (fiets)', " + "status_beschrijving = " + "'" + status_beschrijving + "'" + " WHERE pakketID = " + "'" + pakketid + "'";

          Statement st = conn.createStatement();

          st.executeUpdate(query);
          }
          
          if (this.rol.equals("trein")) {
          String query = "UPDATE Pakket SET pakketstatus = " + "'" + pakketstatus + " (trein)', " + "status_beschrijving = " + "'" + status_beschrijving + "'" + " WHERE pakketID = " + "'" + pakketid + "'";

          Statement st = conn.createStatement();

          st.executeUpdate(query);
          }
          
        }
          catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public boolean getOpgehaald() {
        if (this.pakketstatus.equals("opgehaald (trein") || this.pakketstatus.equals("opgehaald (fiets)")) {
            return true;
        }
        return false;
    }
    
    public boolean getAfgeleverd() {
        if (this.pakketstatus.equals("afgeleverd (trein)") || this.pakketstatus.equals("afgeleverd (fiets)")) {
            return true;
        }
        return false;
    }
    
    public boolean getIncident() {
        if (this.pakketstatus.equals("incident (trein)") || this.pakketstatus.equals("incident (fiets)")) {
            return true;
        }
        return false;
    }  
    
    public int getPakketId() {
        return this.pakketid;
    }
    
    public String getPakketStatus() {
        return this.pakketstatus;
    }
    
    public String getGebruikersnaam() {
        return this.gebruikersnaam;
    }
    
    public String getStatus_Beschrijving() {
        return this.status_beschrijving;
    }
    
    public String getRol() {
        return this.rol;
    }
}
