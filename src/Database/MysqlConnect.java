package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class MysqlConnect {
    // init database constants
    private static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost/KBS?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&autoReconnect=true&useSSL=false";
    private static final String USERNAME = "root"; // 
    private static final String PASSWORD = "1234";
    private static final String MAX_POOL = "250";

    // init connection object
    private Connection connection;
    // init properties object
    private Properties properties;

    // create properties
    private Properties getProperties() { 
        if (properties == null) {
            properties = new Properties();
            properties.setProperty("user", USERNAME);
            properties.setProperty("password", PASSWORD);
            properties.setProperty("MaxPooledStatements", MAX_POOL);
        }
        return properties;
    }

    // connect database
    public Connection connect() { 
        if (connection == null) {
            try {
                Class.forName(DATABASE_DRIVER);
                connection = DriverManager.getConnection(DATABASE_URL, getProperties());
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    // disconnect database
    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public ResultSet getAll(String table){
        ResultSet tableResults = null;
        
        Connection conn = this.connect();

        if(!table.isEmpty()){
            try{
              // Create the query
              String query = "SELECT * FROM " + table;

              // Create the statement
              Statement st = conn.createStatement();

              // Get the data
              ResultSet rs = st.executeQuery(query);
              
              tableResults = rs;
              
              // Close connection
              st.close();
            }catch (SQLException e){
              System.err.println("Got an exception! ");
              System.err.println(e.getMessage());
            }

          
        }
        // Return resultset
        return tableResults;
    }
}