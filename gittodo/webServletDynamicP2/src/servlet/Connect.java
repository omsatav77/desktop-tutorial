package servlet;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {

	public static Connection GetConn() {

		Connection con=null;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");

		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/todotrial", "root", "root");


				
		}
		catch (Exception e) 
		{
		     e.printStackTrace();
		}
		
		return con;
	}

}
