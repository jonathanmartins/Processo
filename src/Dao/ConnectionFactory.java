package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
	public Connection getConnection() {

		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");  

			// Registrado o driver, vamos estabelecer uma conexão  
			return DriverManager.getConnection("jdbc:mysql://localhost/systemredirect","root", "admin");

		} catch(SQLException e) { throw new RuntimeException(e); 
		} catch (ClassNotFoundException e) { e.printStackTrace(); }

		return con;
	}
}
