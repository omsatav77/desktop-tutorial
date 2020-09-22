package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Todotask;

/**
 * Servlet implementation class todoadd
 */
@WebServlet("/todoadd")
public class todoadd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static ServletRequest req;
	static ServletResponse res;
	static PrintWriter out;
	
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		req=request;
    	res=response;
    	out=res.getWriter();
    	
    	
    	tasklist();
    	disptask();		
   	
	}
	public static void tasklist () {
		
		   try {
			   Connection con= Connect.GetConn();
			Statement stm=con.createStatement();
			Todotask.todolist= new ArrayList<>();
			
			
						ResultSet rs = stm.executeQuery("select * from todoadd");
						rs.beforeFirst();
						
						while(rs.next()) {
							if(rs.getString(1).equals(todoservlet.finEmail))
							{
							Todotask todotask=new Todotask();
							todotask.setEmail(rs.getString(1));
							todotask.setTitle1(rs.getString(2));
							todotask.setDesc1(rs.getString(3));
							todotask.setStatus1(rs.getString(4));
							todotask.setId(rs.getInt(5));
							Todotask.todolist.add(todotask);
							}
//							System.out.println(rs.getString(1)+" hiiiiiii");
						}
						rs.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	   		
		}
    public static void disptask() throws ServletException, IOException
    
    { 	
		res.setContentType("text/html");
		out.println("<!DOCTYPE html>");
 		out.println("<html>");
 		out.println("<head>");
 		out.println("<title>View List</title>");
 		out.println("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" integrity=\"sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z\" crossorigin=\"anonymous\">");
 		out.println("<link rel='stylesheet' href='style.css'/>");
 		out.println("</head>");
 		out.println("<body>");
	
 		out.println("<div class='container'>");
 		out.print("<h1 style=\"text-align: center;\">todo list</h1>");
 		out.println("<form action='complete' method='get'>");
 		out.println("<table class='table table-bordered table-striped'>");
 		out.print("<tr><th></th><th>Ttile</th><th>Dscription</th><th>status</th><th>Edit</th><th>Delete</th>");
 		
 		for(Todotask bean:Todotask.todolist){
 
 			out.print("<tr><td><input type='checkbox' name='taskcompleted' value='"+bean.getId()+"' /></td><td>"+bean.getTitle1()+"</td><td>"+bean.getDesc1()+"</td><td>"+bean.getStatus1()+"</td><td ><a href='Edittodotask?id="+bean.getId()+"'>Edit</a></td><td><a href='deletetodotask?id="+bean.getId()+"'>Delete</a></td></tr>");
 			
 			
 		}
 		out.println("</table>");
 		
 		out.println("<br>");
 		out.println("<button type='submit' class=\"btn btn-success\">Complete Task</button>");
 		out.println("<a href=\"todoAdd.html\"><input type=\"button\" class=\"btn btn-primary \" name=\"button \"value=\"Add new Todo\">");
 		out.println("<a id=\"logout\"  href=\"index.html\"><input type=\"button\"  class=\"btn btn-primary \" name=\"button \"value=\"LOG OUT\"></a>");
 		out.println("</form>");
 		out.println("</div>");
 		out.println("</body>");
 		out.println("</html>");
 		
 		out.close();
    }
    	
    }
