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
 * Servlet implementation class inserttodo
 */
@WebServlet("/inserttodo")
public class inserttodo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
   		
PrintWriter out=response.getWriter();
		
		try
		{
	   Connection con= Connect.GetConn();
		
				 
				 String title=request.getParameter("title1");
				 String desc1=request.getParameter("desc1");
				 String sele1=request.getParameter("selec");
				 
				
				String INSERT_USERS_SQL = "INSERT INTO todoadd" +
			            "  (title, desc1, sele1) VALUES " +
			            " (?,?,?);";

				
				PreparedStatement preparedStatement = con.prepareStatement(INSERT_USERS_SQL);
preparedStatement.setString(1, title);
preparedStatement.setString(2,desc1);
preparedStatement.setString(3, sele1);


int result = preparedStatement.executeUpdate();
if(result>0)
response.sendRedirect("index.html");
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
