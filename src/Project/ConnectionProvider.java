package Project;
import java.sql.*; // contains all the classes and interfaces needed for JDBC

public class ConnectionProvider {
	public static Connection getCon(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/bbms",
					"saum","9876.Saum"
					); //Creates a connection to the MySQL database
			return con;
		}
		catch(Exception e){
			e.printStackTrace(); // shows error in the console
			return null;
		}
	}
	
}


/*
 *  JDBC (Java Database Connectivity)
 *  public static Connection getCon(): getCon is the name of method which returns 
 *                                    a Connection object from java.sql.Connection
 *  Class.forName("com.mysql.cj.jdbc.Driver"): Loads the MySQL JDBC driver class and registers the driver with DriverManager
 * 
 *  jdbc:mysql://localhost:3306/bbms
jdbc:mysql:// → tells Java to use the MySQL protocol
localhost → the database is running on your own computer
3306 → default port of MySQL
bbms → the database name (e.g., Blood Bank Management System)
"root" → MySQL username
"1234" → MySQL password
*/