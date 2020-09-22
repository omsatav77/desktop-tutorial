package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.directory.SearchControls;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import dao.Todotask;

/**
 * Servlet implementation class Edittodotask
 */
@WebServlet("/Edittodotask")
public class Edittodotask extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 static int uid;
    
	 PrintWriter out;
	 ServletResponse res;
	 static String tname;
	 static String desc;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		PrintWriter out=response.getWriter();
		uid=Integer.parseInt(request.getParameter("id"));
		Search();
		updatetask.getuid(uid);
		
		response.setContentType("text/html");
		   out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>View List</title>");
			out.println("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" integrity=\"sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z\" crossorigin=\"anonymous\">");
			out.println("</head>");
			out.println("<body>");
			out.println("<div class=\"container\" style=\"padding: 50px\">\r\n" + 
					"<div class=\"row\">\r\n" + 
					"<div class=\"col-sm-4\"></div>\r\n" + 
					"<div class=\"col-sm-3\">\r\n" + 
					"<form action=\"updatetask\" method=\"get\">\r\n" + 
					"TaskName :<input type=\"text\" name=\"tname\" style=\"display: block\" value='"+tname+"'><br>\r\n" + 
					"Description :<input type=\"text\" name=\"desc\" style=\"display: block\" value='"+desc+"'><br>\r\n" + 
					"<button type=\"submit\" class=\"btn btn-primary btn-block\">Update</button>\r\n" + 
					"</form>\r\n" + 
					"</div>\r\n" + 
					"</div>\r\n" + 
					"</div>\r\n" + 
					"\r\n" + 
					"</body>\r\n" + 
					"</html>");
			
	}
	
	public static void Search() {
		for(int i=0;i<Todotask.todolist.size();i++) {
			if(Todotask.todolist.get(i).getId()==uid) {
				tname=Todotask.todolist.get(i).getTitle1();
				desc=Todotask.todolist.get(i).getDesc1();
			}
		}
	}
	}


