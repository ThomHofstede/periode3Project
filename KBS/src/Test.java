
import static Database.DatabaseConnection.*;
import java.sql.*;


/**
 *
 * @author Olink
 */
public class Test {
    
    public static void main (String [] args) {
        
        
        
        try {
        executeQuery("gebruikersnaam", "Gebruiker");
        
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        
    }
}
