package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registration1")
public class registration1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	PrintWriter out=response.getWriter();
		
		try
		{
	   Connection con= Connect.GetConn();
		
				 
				 String fname=request.getParameter("name1");
				 String lname=request.getParameter("lname");
				 String email1=request.getParameter("email");
				 String gendar=request.getParameter("radio");
				 String pass=request.getParameter("password");
				 String DateOfBirth=request.getParameter("date1");
				 
				
				String INSERT_USERS_SQL = "INSERT INTO registration" +
			            "  (fname, lname, email1, gendar, pass,DateOfBirth) VALUES " +
			            " (?,?,?,?,?,?);";

				
				PreparedStatement preparedStatement = con.prepareStatement(INSERT_USERS_SQL);
preparedStatement.setString(1, fname);
preparedStatement.setString(2,lname);
preparedStatement.setString(3, email1);
preparedStatement.setString(4, gendar);
preparedStatement.setString(5,pass);
preparedStatement.setString(6,DateOfBirth);

int result = preparedStatement.executeUpdate();
if(result>0) {
	
	response.sendRedirect("index.html");
}
else
	response.sendRedirect("SignUpUnsuccessful.html");
	
//				 out.println("working");

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
