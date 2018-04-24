/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author thomhofstede
 */
public class Project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MysqlConnect dbconnection = new MysqlConnect();
        
        dbconnection.connect();
        
        try
        {
          // create our mysql database connection
          Connection conn = dbconnection.connect();

          // our SQL SELECT query. 
          // if you only need a few columns, specify them by name instead of using "*"
          String query = "SELECT * FROM test";

          // create the java statement
          Statement st = conn.createStatement();

          // execute the query, and get a java resultset
          ResultSet rs = st.executeQuery(query);

          // iterate through the java resultset
          while (rs.next())
          {
            int id = rs.getInt("id");


            // print the results
            System.out.format("%s", id + "\n");
          }
          st.close();
        }catch (Exception e){
          System.err.println("Got an exception! ");
          System.err.println(e.getMessage());
        }
  }
        
    
    
}
