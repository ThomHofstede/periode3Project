
package Database;

import java.sql.*;

/**
 *
 * @author Olink
 */
public class DatabaseConnection {
    
    public DatabaseConnection() {
    }
    
    public static void executeQuery(String attributen, String tabel) {
         try {
            Connection con = null;
            Statement st = null;
             
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/KBS?autoReconnect=true&useSSL=false", "root", "root");
            st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT " + attributen + " FROM " + tabel);
            
            while (rs.next()) {
                String g = rs.getString("gebruikersnaam");
                
                System.out.println(g);
            }
        rs.close();
        st.close();
        con.close();
        }
        catch (Exception e)  {
            System.out.println(e.getMessage());
        }
    }
    
    public static void Disconnect() {
        ResultSet resultSet = null;
        Statement statement = null;
        Connection connection = null;
        
        try {
        resultSet.close();
        statement.close();
        connection.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
