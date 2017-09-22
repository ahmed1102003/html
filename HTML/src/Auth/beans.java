package Auth;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class beans {
	

	public ArrayList<String> search( String foodtype, String location) throws SQLException {
		
		 // Open a connection
        String URL = "jdbc:mysql://localhost:3306/html";
        String username = "root";
        String password = "root";
        
        try
        {
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
        }		 
        
        catch ( Exception e)
        {
       	 e.printStackTrace();
        }
        
       // Class.forName("com.mysql.jdbc.Driver");
		  Connection con = DriverManager.getConnection(URL,username,password);
	
	 try
	 {
           
		// Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		 //String time = timestamp.toString().split(" ")[1].toString();
						 
		 
         // Create the Statement Object 
         Statement stmt = con.createStatement();
         
         // Execute SQL query 
         String sql = "SELECT location, foodtype, images FROM html.new_table Where foodtype = '" + foodtype + "' and location = '" + location+"'";
        
         ArrayList<String> ar = new ArrayList<String>();
         
         ResultSet  rs = stmt.executeQuery(sql); 
         
         while (rs.next())
         {
        
        	String csv = new String();
        	 
        	 csv +="Foodtype is : "+ rs.getString("foodtype") + ","; 
         	csv += "The location of the rest is " + rs.getString("location") + "\n" ;
         	csv += rs.getString("images") + ",";
         	
         	ar.add(csv);
    
         }
       
        // return the Array list to the Backend
       return ar;
         
 	 }		 
          catch ( Exception e){
         	 e.printStackTrace();
          }
 	 
 	 finally {
 		 con.close();
 	 }
 	 
 	 //if there is an error it will return null to the Backend
 	return null;
       
	}
	

}
