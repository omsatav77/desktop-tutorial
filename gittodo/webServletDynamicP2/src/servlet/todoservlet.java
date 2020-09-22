package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

@WebServlet("/todoservlet")
public class todoservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
static String finEmail="";
static String adm="";
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			
	   Connection con= Connect.GetConn();
		Statement stm=con.createStatement();
		
		String query=null;
				 String user1=request.getParameter("user1");
				 String pass1=request.getParameter("pass1");
				 boolean flag=false;
				 
				 
				 if(user1.equalsIgnoreCase("admin")&&pass1.equalsIgnoreCase("admin"))
				 {
					 response.sendRedirect("adminpage");
					 
				 }
				 
					query="select * from registration";
					
				 
				 ResultSet rss=stm.executeQuery(query);
				 while(rss.next())
				 {
					  adm=rss.getString(7); 
					 String samp=rss.getString(3);
					 
					 if(samp.equals(user1)&&pass1.equals(rss.getString(5))&&rss.getString(8).equals("activated"))
					 {
						 flag=true;
						 finEmail=samp;
						 break;
					 }
					 else {
						 flag=false;
					 }
					 
				 }
				  if ( flag==true )
				 {
					  System.out.println("done final email todoservlet email"+finEmail);
					  response.sendRedirect("todoadd");
				}
				 else  
				 {
 					 response.sendRedirect("wrongpass.html");
				        }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
}