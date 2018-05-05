
package Pakketten;

import Database.MysqlConnect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Olink
 */
public class Pakket extends Station {
    private int pakketid;
    private String pakketstatus;
    private String status_beschrijving;
    private String gebruikersnaam;
    private Station vertrek;
    private Station aankomst;
    
    public Pakket(String gebruikersnaam) {
        MysqlConnect dbconn = new MysqlConnect();
        
        try {     
        // create our mysql database connection
          Connection conn = dbconn.connect();

          // our SQL SELECT query. 
          // if you only need a few columns, specify them by name instead of using "*"
          String query = "SELECT * FROM Pakket";

          // create the java statement
          Statement st = conn.createStatement();

          // execute the query, and get a java resultset
          ResultSet rs = st.executeQuery(query);
          
          while (rs.next()) {
              int pi = rs.getInt("pakketID");
              String ps = rs.getString("pakketstatus");
              String g = rs.getString("gebruikersnaam");
              
              if (gebruikersnaam.equals(g)) {
                  this.pakketid = pi;
                  this.pakketstatus = ps;
                  this.gebruikersnaam = g;
              }
          }
          
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void updatePakket(String gebruikersnaam, String pakketstatus) {
        MysqlConnect dbconn = new MysqlConnect();
        
        try {     
        // create our mysql database connection
          Connection conn = dbconn.connect();

          // our SQL SELECT query. 
          // if you only need a few columns, specify them by name instead of using "*"
          String query = "UPDATE Pakket SET pakketstatus = " + "'" + pakketstatus + "'" + " WHERE gebruikersnaam = " + "'" + gebruikersnaam + "'";

          // create the java statement
          Statement st = conn.createStatement();

          // execute the query
          st.executeUpdate(query);
          
        }
          catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void updatePakket(String gebruikersnaam, String pakketstatus, String status_beschrijving) {
        MysqlConnect dbconn = new MysqlConnect();
        
        try {     
        // create our mysql database connection
          Connection conn = dbconn.connect();

          // our SQL SELECT query. 
          // if you only need a few columns, specify them by name instead of using "*"
          String query = "UPDATE Pakket SET pakketstatus = " + "'" + pakketstatus + "', " + "status_beschrijving = " + "'" + status_beschrijving + "'" + " WHERE gebruikersnaam = " + "'" + gebruikersnaam + "'";

          // create the java statement
          Statement st = conn.createStatement();

          // execute the query
          st.executeUpdate(query);
          
        }
          catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public boolean getOpgehaald() {
        if (this.pakketstatus.equals("opgehaald")) {
            return true;
        }
        return false;
    }
    
    public boolean getAfgeleverd() {
        if (this.pakketstatus.equals("afgeleverd")) {
            return true;
        }
        return false;
    }
    
    public boolean getIncident() {
        if (this.pakketstatus.equals("incident")) {
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
}
