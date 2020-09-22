package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Addtodo
 */
@WebServlet("/Addtodo")
public class Addtodo extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
			
			try
			{
		   Connection con= Connect.GetConn();
			
					 
					 String title1=request.getParameter("title1");
					 String desc1=request.getParameter("desc1");
				 
					 String email1=todoservlet.finEmail;
					System.out.println("final email in "+email1);
					String INSERT_USERS_SQL = "INSERT INTO todoadd" +
				            "  (email, title, desc1) VALUES " +
				            " (?,?,?);";

					
					PreparedStatement preparedStatement = con.prepareStatement(INSERT_USERS_SQL);
	preparedStatement.setString(1, email1);
	preparedStatement.setString(2,title1);
	preparedStatement.setString(3, desc1);

	int result = preparedStatement.executeUpdate();
	if(result>0)
	{
	response.sendRedirect("todoAdd");
	}
	else
	{
		response.sendRedirect("todoAdd");
	}	
//					 out.println("working todo addinggg");

			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
