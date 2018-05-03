
package Pakketten;

import Database.MysqlConnect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Olink
 */
public class Pakket {
    private int pakketid;
    private String pakketstatus;
    private String treinkoerier;
    
    public Pakket(String treinkoerier) {
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
              String t = rs.getString("treinkoerier");
              
              if (treinkoerier.equals(t)) {
                  this.pakketid = pi;
                  this.pakketstatus = ps;
                  this.treinkoerier = t;
              }
          }
          
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public int getPakketId() {
        return this.pakketid;
    }
    
    public String getPakketStatus() {
        return this.pakketstatus;
    }
    
    public void setPakketStatus() {
        this.pakketstatus = pakketstatus;
    }
    
    public String getTreinkoerier() {
        return this.treinkoerier;
    }
}
