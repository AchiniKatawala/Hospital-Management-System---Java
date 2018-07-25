
package hospitalmanagementsystem;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;





public class DBOperations {
    String url="jdbc:mysql://localhost:3306/hmsdb";
    String username="root";
    String password="";
    Connection con=null;
    PreparedStatement pst=null;
    
    boolean addNewUser(hms hm){
        try{
        con= (Connection)DriverManager.getConnection(url, username, password);//get the connection
        String query = "INSERT INTO newuser VALUES (?,?)";
        
        pst = (PreparedStatement)con.prepareStatement(query);
        
        pst.setString(1, hm.getUsername());//add values to the sql query
        pst.setString(2, hm.getPassword());//add values to the sql query
        
        pst.executeUpdate();//execute the sql query and insert values to the db table
        
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (pst != null) {
                    con.close();
                }
            } catch (Exception e) {
            }
        }
    }
    
}
